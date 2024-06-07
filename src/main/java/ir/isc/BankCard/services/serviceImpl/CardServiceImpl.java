package ir.isc.BankCard.services.serviceImpl;

import ir.isc.BankCard.config.GeneralConfigProperties;
import ir.isc.BankCard.dto.CardDto;
import ir.isc.BankCard.dto.CardInfoRequestDto;
import ir.isc.BankCard.dto.CreateCardRequestDto;
import ir.isc.BankCard.dto.PersonDto;
import ir.isc.BankCard.entities.CardEntity;
import ir.isc.BankCard.entities.CardIssuerEntity;
import ir.isc.BankCard.entities.PersonEntity;
import ir.isc.BankCard.models.Card;
import ir.isc.BankCard.models.IssuerCardTypeModel;
import ir.isc.BankCard.models.Person;
import ir.isc.BankCard.repositories.CardRepository;
import ir.isc.BankCard.services.service.CardIssuerService;
import ir.isc.BankCard.services.service.CardService;
import ir.isc.BankCard.services.service.PersonCardsInMemoryService;
import ir.isc.BankCard.services.service.PersonService;
import ir.isc.BankCard.util.mapper.CardMapper;
import ir.isc.BankCard.util.mapper.PersonMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
@Validated
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final PersonService personService;
    private final CardIssuerService cardIssuerService;
    private final PersonCardsInMemoryService personCardsInMemoryService;

    private final PersonMapper personMapper;
    private final CardMapper cardMapper;
    private final GeneralConfigProperties generalConfigProperties;

    @Override
    public CardDto create(@Valid CardDto cardDto) throws Exception {
        Card card = cardMapper.getCardModelFromCardDto(cardDto);
        PersonDto personDto = cardDto.getPersonDto();
        Optional<Person> personOptional = personCardsInMemoryService.get(personDto.getNationalCode());

        CardEntity cardEntity = null;

        if (personOptional.isPresent()){
            Person person = personOptional.get();
            Boolean validForSaving = checkPersonCardsValidation(person, card);
            if (validForSaving){
                //update inMemory repository
                person.getCards().add(card);
                personCardsInMemoryService.createUpdate(person);

                //update db
                if (generalConfigProperties.getDbEnabled()){
                    cardEntity = updateDbRepository(cardDto);
                }

            }else {
                throw new Exception();
            }
        }else {
            Person person = personMapper.getPersonModelFromPersonDto(personDto);
            person.getCards().add(card);
            personCardsInMemoryService.createUpdate(person);

            //persist in db
            if (generalConfigProperties.getDbEnabled()){
                cardEntity = persistDbRepository(cardDto);
            }

        }

        return Objects.isNull(cardEntity) ? cardDto : cardMapper.getCardDtoFromCardEntity(cardEntity);
    }

    @Override
    public List<CardDto> createAll(@Valid CreateCardRequestDto createCardRequestDto) {
        List<CardDto> result = new ArrayList<>();
        createCardRequestDto.getCardDtos().forEach(cardDto -> {
            try {
                cardDto = create(cardDto);
                result.add(cardDto);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return null;
    }

    @Override
    public List<CardDto> getAll(CardInfoRequestDto cardInfoRequestDto) {
        List<Card> cards = personCardsInMemoryService.getCards(cardInfoRequestDto);
        return cardMapper.getCardDtoListFromCardModelList(cards);
    }

    private Boolean checkPersonCardsValidation(Person person, Card newCard){
        Set<IssuerCardTypeModel> issuerCardTypeModels = person.getCards()
                .stream()
                .map(card -> new IssuerCardTypeModel(card.getCardIssuer().getCode(), card.getType())).collect(Collectors.toSet());
        return !issuerCardTypeModels.contains(new IssuerCardTypeModel(newCard.getCardIssuer().getCode(), newCard.getType()));
    }

    private CardEntity updateDbRepository(CardDto cardDto) throws Exception {

        PersonDto personDto = cardDto.getPersonDto();
        CardEntity cardEntity = cardMapper.getCardEntityFromCardDto(cardDto);

        PersonEntity personEntity = personService
                .getByNationalCode(personDto.getNationalCode())
                .orElseThrow(Exception::new);

        CardIssuerEntity cardIssuerEntity = cardIssuerService
                .getByCode(cardDto.getCardIssuerDto().getCode())
                .orElseThrow(Exception::new);

        cardEntity.setCardIssuerEntity(cardIssuerEntity);
        cardEntity.setPersonEntity(personEntity);

        return cardRepository.save(cardEntity);
    }

    private CardEntity persistDbRepository(CardDto cardDto) throws Exception {

        PersonDto personDto = cardDto.getPersonDto();
        CardEntity cardEntity = cardMapper.getCardEntityFromCardDto(cardDto);
        PersonEntity personEntity = personMapper.getPersonEntityFromPersonDto(personDto);
        personEntity = personService.create(personEntity);

        CardIssuerEntity cardIssuerEntity = cardIssuerService
                .getByCode(cardDto.getCardIssuerDto().getCode())
                .orElseThrow(Exception::new);

        cardEntity.setCardIssuerEntity(cardIssuerEntity);
        cardEntity.setPersonEntity(personEntity);
        return cardRepository.save(cardEntity);
    }
}

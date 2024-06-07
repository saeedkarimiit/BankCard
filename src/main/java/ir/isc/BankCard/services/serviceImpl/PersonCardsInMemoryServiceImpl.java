package ir.isc.BankCard.services.serviceImpl;

import ir.isc.BankCard.dto.CardInfoRequestDto;
import ir.isc.BankCard.models.Card;
import ir.isc.BankCard.models.Person;
import ir.isc.BankCard.repositories.PersonCardsInMemoryRepository;
import ir.isc.BankCard.services.service.PersonCardsInMemoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
@Validated
public class PersonCardsInMemoryServiceImpl implements PersonCardsInMemoryService {

    private final PersonCardsInMemoryRepository personCardsInMemoryRepository;

    @Override
    public Person createUpdate(@Valid Person person) {
        return personCardsInMemoryRepository.save(person);
    }

    @Override
    public Optional<Person> get(@NotNull @NotEmpty String nationalCode) throws Exception {
        return personCardsInMemoryRepository.findById(nationalCode);
    }

    @Override
    public List<Card> getCards(CardInfoRequestDto cardInfoRequestDto) {
        List<Person> personList = (List<Person>) personCardsInMemoryRepository.findAll();
        personList = CollectionUtils.isNotEmpty(cardInfoRequestDto.getNationalCodes())
                ? personList.stream().filter(person -> cardInfoRequestDto.getNationalCodes().contains(person.getNationalCode())).collect(Collectors.toList())
                : personList;
        List<Card> cards = CollectionUtils.isNotEmpty(cardInfoRequestDto.getPanList())
                ? personList.stream().flatMap(person -> person.getCards().stream()).filter(card -> cardInfoRequestDto.getPanList().contains(card.getPan())).collect(Collectors.toList())
                : personList.stream().flatMap(person -> person.getCards().stream()).collect(Collectors.toList());

        cards = CollectionUtils.isNotEmpty(cardInfoRequestDto.getAccountNumbers())
                ? cards.stream().filter(card -> cardInfoRequestDto.getAccountNumbers().contains(card.getAccountNumber())).collect(Collectors.toList())
                : cards;
        return cards;
    }
}

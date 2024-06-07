package ir.isc.BankCard.services.serviceImpl;

import ir.isc.BankCard.dto.CardInfoRequestDto;
import ir.isc.BankCard.dto.CardIssuerDto;
import ir.isc.BankCard.entities.CardIssuerEntity;
import ir.isc.BankCard.repositories.CardIssuerRepository;
import ir.isc.BankCard.repositories.CardRepository;
import ir.isc.BankCard.services.service.CardIssuerService;
import ir.isc.BankCard.util.mapper.CardIssuerMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
@Validated
public class CardIssuerServiceImp implements CardIssuerService {

    private final CardIssuerRepository cardIssuerRepository;
    private final CardIssuerMapper cardIssuerMapper;

    @Override
    public CardIssuerDto create(@Valid CardIssuerDto cardIssuerDto) throws Exception {
        CardIssuerEntity cardIssuerEntity = cardIssuerMapper.getCardIssuerEntityFromCardIssuerDto(cardIssuerDto);
        cardIssuerEntity = cardIssuerRepository.save(cardIssuerEntity);
        return cardIssuerMapper.getCardIssuerDtoFromCardIssuerEntity(cardIssuerEntity);
    }

    @Override
    public List<CardIssuerDto> createAll(@Valid List<CardIssuerDto> cardIssuerDtoList) throws Exception {
        List<CardIssuerEntity> cardIssuerEntityList = cardIssuerMapper.getCardIssuerEntityListFromCardIssuerDtoList(cardIssuerDtoList);
        cardIssuerEntityList = cardIssuerRepository.saveAll(cardIssuerEntityList);
        return cardIssuerMapper.getCardIssuerDtoListFromCardIssuerEntityList(cardIssuerEntityList);
    }

    @Override
    public CardIssuerDto get(String code) throws Exception {
        CardIssuerEntity cardIssuerEntity = cardIssuerRepository
                .findByCode(code)
                .orElseThrow(Exception::new);
        return cardIssuerMapper.getCardIssuerDtoFromCardIssuerEntity(cardIssuerEntity);
    }

    @Override
    public List<CardIssuerDto> getAll() {
        List<CardIssuerEntity> cardIssuerEntityList = cardIssuerRepository.findAll();
        return cardIssuerMapper.getCardIssuerDtoListFromCardIssuerEntityList(cardIssuerEntityList);
    }

    @Override
    public Optional<CardIssuerEntity> getByCode(@NotNull @NotEmpty String code) {
        return  cardIssuerRepository.findByCode(code);
    }
}

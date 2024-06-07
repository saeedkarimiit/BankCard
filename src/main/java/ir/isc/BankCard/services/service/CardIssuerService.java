package ir.isc.BankCard.services.service;

import ir.isc.BankCard.dto.CardIssuerDto;
import ir.isc.BankCard.entities.CardIssuerEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface CardIssuerService {

    CardIssuerDto create(@Valid CardIssuerDto cardIssuerDto) throws Exception;

    List<CardIssuerDto> createAll(@Valid List<CardIssuerDto> cardIssuerDtoList) throws Exception;

    CardIssuerDto get(String code) throws Exception;

    List<CardIssuerDto> getAll();

    Optional<CardIssuerEntity> getByCode(@NotNull @NotEmpty String code);
}

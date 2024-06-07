package ir.isc.BankCard.services.service;

import ir.isc.BankCard.dto.CardDto;
import ir.isc.BankCard.dto.CardInfoRequestDto;
import ir.isc.BankCard.dto.CreateCardRequestDto;
import jakarta.validation.Valid;

import java.util.List;

public interface CardService {

    CardDto create(@Valid CardDto cardDto) throws Exception;

    List<CardDto> createAll(@Valid CreateCardRequestDto createCardRequestDto) throws Exception;

    List<CardDto> getAll(CardInfoRequestDto cardInfoRequestDto);
}

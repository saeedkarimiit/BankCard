package ir.isc.BankCard.services.service;

import ir.isc.BankCard.dto.CardInfoRequestDto;
import ir.isc.BankCard.models.Card;
import ir.isc.BankCard.models.Person;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface PersonCardsInMemoryService {
    Person createUpdate(@Valid Person person);
    Optional<Person> get(@NotNull @NotEmpty String nationalCode) throws Exception;
    List<Card> getCards(CardInfoRequestDto cardInfoRequestDto);
}

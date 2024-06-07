package ir.isc.BankCard.services.service;

import ir.isc.BankCard.dto.PersonDto;
import ir.isc.BankCard.entities.PersonEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    PersonDto create(@Valid PersonDto personDto);

    PersonEntity create(@Valid PersonEntity personEntity);

    List<PersonDto> creatAll(@Valid List<PersonDto> personDtoList);

    Optional<PersonEntity> getByNationalCode(@NotNull @NotEmpty String nationalCode);

}

package ir.isc.BankCard.util.mapper;

import ir.isc.BankCard.dto.PersonDto;
import ir.isc.BankCard.entities.PersonEntity;
import ir.isc.BankCard.models.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person getPersonModelFromPersonDto(PersonDto personDto);

    PersonEntity getPersonEntityFromPersonDto(PersonDto personDto);

    PersonDto getPersonDtoFromPersonEntity(PersonEntity personEntity);

    PersonDto getPersonDtoFromPersonMode(Person person);

    List<PersonEntity> getPersonEntityListFromPersonDtoList(List<PersonDto> personDtoList);

    List<PersonDto> getPersonDtoListFromPersonEntityList(List<PersonEntity> personEntityList);
}

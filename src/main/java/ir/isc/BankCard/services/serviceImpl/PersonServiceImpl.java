package ir.isc.BankCard.services.serviceImpl;

import ir.isc.BankCard.dto.PersonDto;
import ir.isc.BankCard.entities.PersonEntity;
import ir.isc.BankCard.repositories.PersonRepository;
import ir.isc.BankCard.services.service.PersonService;
import ir.isc.BankCard.util.mapper.PersonMapper;
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
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public PersonDto create(@Valid PersonDto personDto) {
        PersonEntity personEntity = personMapper.getPersonEntityFromPersonDto(personDto);
        personEntity = personRepository.save(personEntity);
        return personMapper.getPersonDtoFromPersonEntity(personEntity);
    }

    @Override
    public PersonEntity create(@Valid PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }

    @Override
    public List<PersonDto> creatAll(@Valid List<PersonDto> personDtoList) {
        List<PersonEntity> personEntityList = personMapper.getPersonEntityListFromPersonDtoList(personDtoList);
        personEntityList = personRepository.saveAll(personEntityList);
        return personMapper.getPersonDtoListFromPersonEntityList(personEntityList);
    }

    @Override
    public Optional<PersonEntity> getByNationalCode(@NotNull @NotEmpty String nationalCode) {
        return personRepository.findByNationalCode(nationalCode);
    }
}

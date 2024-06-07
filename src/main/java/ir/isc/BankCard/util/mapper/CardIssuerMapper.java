package ir.isc.BankCard.util.mapper;

import ir.isc.BankCard.dto.CardIssuerDto;
import ir.isc.BankCard.entities.CardIssuerEntity;
import ir.isc.BankCard.models.CardIssuer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardIssuerMapper {
    CardIssuer getCardIssuerModelFromCardIssuerDto(CardIssuerDto cardIssuerDto);

    @Mapping(target = "id", ignore = true)
    CardIssuerEntity getCardIssuerEntityFromCardIssuerDto(CardIssuerDto cardIssuerDto);

    CardIssuerDto getCardIssuerDtoFromCardIssuerEntity(CardIssuerEntity cardIssuerEntity);

    CardIssuerDto getCardIssuerDtoFromCardIssuerModel(CardIssuer cardIssuer);

    List<CardIssuerEntity> getCardIssuerEntityListFromCardIssuerDtoList(List<CardIssuerDto> cardIssuerDtoList);

    List<CardIssuerDto> getCardIssuerDtoListFromCardIssuerEntityList(List<CardIssuerEntity> cardIssuerEntityList);
}

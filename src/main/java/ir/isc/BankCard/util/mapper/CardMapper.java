package ir.isc.BankCard.util.mapper;

import ir.isc.BankCard.dto.CardDto;
import ir.isc.BankCard.entities.CardEntity;
import ir.isc.BankCard.enums.CardStatus;
import ir.isc.BankCard.enums.CardType;
import ir.isc.BankCard.models.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {
    @Mapping(target = "type", source = "type", qualifiedByName = "cardTypeEnumFromInt")
    @Mapping(target = "cardStatus", source = "cardStatus", qualifiedByName = "cardStatusEnumFromInt")
    @Mapping(target = "cardIssuer", source = "cardIssuerDto")
    Card getCardModelFromCardDto(CardDto cardDto);

    List<Card> getCardMolesFromCardDtos(List<CardDto> cardDtos);

    @Mapping(target = "type", source = "type", qualifiedByName = "cardTypeEnumFromInt")
    @Mapping(target = "cardStatus", source = "cardStatus", qualifiedByName = "cardStatusEnumFromInt")
    CardEntity getCardEntityFromCardDto(CardDto cardDto);

    @Mapping(target = "type", source = "type", qualifiedByName = "IntegerFromCardTypeEnum")
    @Mapping(target = "cardStatus", source = "cardStatus", qualifiedByName = "IntegerFromCardStatus")
    @Mapping(target = "personDto", source = "personEntity")
    @Mapping(target = "cardIssuerDto", source = "cardIssuerEntity")
    CardDto getCardDtoFromCardEntity(CardEntity cardEntity);

    @Mapping(target = "type", source = "type", qualifiedByName = "IntegerFromCardTypeEnum")
    @Mapping(target = "cardStatus", source = "cardStatus", qualifiedByName = "IntegerFromCardStatus")
    @Mapping(target = "personDto", source = "person")
    @Mapping(target = "cardIssuerDto", source = "cardIssuer")
    CardDto getCardDtoFromCardMode(Card card);

    List<CardDto> getCardDtoListFromCardModelList(List<Card> cardList);

    @Named("cardTypeEnumFromInt")
    default CardType getCardTypeEnumFromInteger(Integer value){
        return CardType.getStaticByValue(value);
    }

    @Named("cardStatusEnumFromInt")
    default CardStatus getCardStatusEnumFromInteger(Integer value){
        return CardStatus.getStaticByValue(value);
    }

    @Named("IntegerFromCardTypeEnum")
    default Integer getIntegerFromCardType(CardType cardType){
        return cardType.getValue();
    }

    @Named("IntegerFromCardStatus")
    default Integer getIntegerFromCardStatus(CardStatus cardStatus){
        return cardStatus.getValue();
    }
}

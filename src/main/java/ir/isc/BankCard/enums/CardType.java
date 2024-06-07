package ir.isc.BankCard.enums;

import ir.isc.BankCard.entities.converters.AbstractEnumConverter;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The {@code CardType} class represents types of card.
 *
 * @author  Saeed Karimi
 * @since   0.0.1
 */
public enum CardType implements PersistableEnum<CardType,Integer>{
    CREDIT(1),
    DEBIT(2);

    private final int value;
    private static final Map<Integer, CardType> map;

    static {
        map = Stream.of(CardType.values())
                .collect(Collectors.toMap(CardType::getValue, cardType -> cardType));
    }

    CardType(int value) {
        this.value = value;
    }

    public static CardType getStaticByValue(Integer value){
        return map.get(value);
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public CardType getByValue(Integer value) {
        return map.get(value);
    }

    public static class converter extends AbstractEnumConverter<CardType,Integer>{

        public converter() {
            super(CardType.class)   ;
        }
    }
}

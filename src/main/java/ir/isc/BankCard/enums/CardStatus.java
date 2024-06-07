package ir.isc.BankCard.enums;

import ir.isc.BankCard.entities.converters.AbstractEnumConverter;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The {@code CardStatus} class represents status of card.
 *
 * @author  Saeed Karimi
 * @since   0.0.1
 */
public enum CardStatus implements PersistableEnum<CardStatus, Integer>{

    ACTIVE(1),
    INACTIVE(2);

    private final int value;
    private static final Map<Integer, CardStatus> map;

    static {
        map = Stream.of(CardStatus.values())
                .collect(Collectors.toMap(CardStatus::getValue, cardStatus -> cardStatus));
    }

    CardStatus(int value) {
        this.value = value;
    }

    public static CardStatus getStaticByValue(Integer value){
        return map.get(value);
    }


    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public CardStatus getByValue(Integer value) {
        return map.get(value);
    }

    public static class converter extends AbstractEnumConverter<CardStatus,Integer> {

        public converter() {
            super(CardStatus.class)   ;
        }
    }
}

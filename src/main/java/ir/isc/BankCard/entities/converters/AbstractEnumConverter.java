package ir.isc.BankCard.entities.converters;

import ir.isc.BankCard.enums.PersistableEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Objects;
import java.util.stream.Stream;

@Converter
public abstract class AbstractEnumConverter<E extends Enum<E> & PersistableEnum<E,T>, T> implements AttributeConverter<E,T> {

    private final Class<E> clazz;

    public AbstractEnumConverter(Class<E> clazz){
        this.clazz = clazz;
    }

    @Override
    public T convertToDatabaseColumn(E attribute) {
        return Objects.isNull(attribute) ? null : attribute.getValue();
    }

    @Override
    public E convertToEntityAttribute(T dbData) {
        return Objects.isNull(dbData)
                ? null
                : Stream.of(clazz.getEnumConstants())
                .filter(e -> e.getValue().equals(dbData))
                .findFirst()
                .orElse(null);
    }
}

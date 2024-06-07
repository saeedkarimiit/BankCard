package ir.isc.BankCard.enums;

public interface PersistableEnum<E,T> {
    T getValue();
    E getByValue(T value);
}

package ir.isc.BankCard.repositories;

import ir.isc.BankCard.models.Person;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PersonCardsInMemoryRepository extends InMemoryRepository<Person, String> {
    private final static Function<Person, String> idGetter = Person::getNationalCode;
    public PersonCardsInMemoryRepository() {
        super(idGetter);
    }
}

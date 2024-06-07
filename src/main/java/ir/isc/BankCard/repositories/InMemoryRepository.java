package ir.isc.BankCard.repositories;

import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InMemoryRepository<T, U extends Serializable> implements CrudRepository<T, U> {

    private final Map<U, T> map = new ConcurrentHashMap<>();

    private final Function<T, U> idGetter;

    public InMemoryRepository(Function<T, U> idGetter) {
        this.idGetter = idGetter;
    }

    @Override
    public <S extends T> S save(@NonNull S entity) {
        U u = idGetter.apply(entity);
        map.put(u, entity);
        return entity;
    }

    @Override
    public <S extends T> Iterable<S> saveAll(@NonNull Iterable<S> entities) {
        entities.forEach(this::save);
        return entities;
    }

    @Override
    public Optional<T> findById(U u) {
        return Optional.ofNullable(map.get(u));
    }

    @Override
    public boolean existsById(U u) {
        return map.containsKey(u);
    }

    @Override
    public Iterable<T> findAll() {
        return map.values();
    }

    @Override
    public Iterable<T> findAllById(@NonNull Iterable<U> us) {
        List<U> uList = new ArrayList<U>();
        us.forEach(uList::add);
        return map.values().stream()
                .filter(item -> uList.contains(idGetter.apply(item)))
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return map.size();
    }

    @Override
    public void deleteById(U u) {
        map.remove(u);
    }

    @Override
    public void delete(@NonNull T entity) {
        U u = idGetter.apply(entity);
        deleteById(u);
    }

    @Override
    public void deleteAllById(Iterable<? extends U> us) {

    }

    @Override
    public void deleteAll(@NonNull Iterable<? extends T> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        map.clear();
    }
}

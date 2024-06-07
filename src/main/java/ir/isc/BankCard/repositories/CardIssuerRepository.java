package ir.isc.BankCard.repositories;

import ir.isc.BankCard.entities.CardIssuerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardIssuerRepository extends JpaRepository<CardIssuerEntity, Long> {
    Optional<CardIssuerEntity> findByCode(String code);
}

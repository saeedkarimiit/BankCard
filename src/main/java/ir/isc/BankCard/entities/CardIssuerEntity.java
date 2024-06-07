package ir.isc.BankCard.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * The {@code CardIssuerEntity} class represents card issuer information.
 *
 * @author  Saeed Karimi
 * @see     BaseEntity
 * @since   0.0.1
 */
@Entity
@Getter
@Setter
@Table(name = "CARD_ISSUER")
public class CardIssuerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CardIssuer_SEQ_GENERATOR")
    @SequenceGenerator(name = "CardIssuer_SEQ_GENERATOR", sequenceName = "CardIssuer_SEQUENCE")
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE", unique = true, nullable = false, length = 6)
    private String code;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "cardIssuerEntity", fetch = FetchType.LAZY)
    Set<CardEntity> cardEntities;

}

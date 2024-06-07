package ir.isc.BankCard.entities;

import ir.isc.BankCard.enums.CardStatus;
import ir.isc.BankCard.enums.CardType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The {@code CardEntity} class represents card information.
 *
 * @author  Saeed Karimi
 * @see     BaseEntity
 * @since   0.0.1
 */
@Entity
@Getter
@Setter
@Table(name = "CARD")
public class CardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARD_SEQ_GENERATOR")
    @SequenceGenerator(name = "CARD_SEQ_GENERATOR", sequenceName = "CARD_SEQUENCE")
    @Column(name = "ID")
    private Long id;

    @Convert(converter = CardType.converter.class)
    @Column(name = "TYPE")
    private CardType type;

    @Column(name = "PAN",unique = true, nullable = false, length = 16)
    private String pan;

    @Column(name = "ACCOUNT_NUMBER" , nullable = false, length = 10)
    private String accountNumber;//todo: separate account entity if needed

    @Column(name = "EXPIRE_DATE" ,nullable = false)
    private String expireDate;

    @Convert(converter = CardStatus.converter.class)
    @Column(name = "CARD_STATUS" ,nullable = false)
    private CardStatus cardStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REL_CARD_ISSUER_CODE", referencedColumnName = "CODE")
    private CardIssuerEntity cardIssuerEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REL_PERSON_ID", referencedColumnName = "ID")
    PersonEntity personEntity;
}

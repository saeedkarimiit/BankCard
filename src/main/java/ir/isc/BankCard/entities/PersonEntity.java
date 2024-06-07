package ir.isc.BankCard.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * The {@code PersonEntity} class represents person information.
 *
 * @author  Saeed Karimi
 * @see     BaseEntity
 * @since   0.0.1
 */
@Entity
@Getter
@Setter
@Table(name = "PERSON")
public class PersonEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ_GENERATOR")
    @SequenceGenerator(name = "PERSON_SEQ_GENERATOR", sequenceName = "PERSON_SEQUENCE")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NATIONAL_CODE" ,unique = true, nullable = false, length = 10)
    private String nationalCode;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ADDRESS")
    private String address;

    @OneToMany(mappedBy = "personEntity", fetch = FetchType.LAZY)
    Set<CardEntity> cardEntities;

}

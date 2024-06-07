package ir.isc.BankCard.models;

import ir.isc.BankCard.enums.CardStatus;
import ir.isc.BankCard.enums.CardType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

/**
 * The {@code Card} class represents card information.
 *
 * @author  Saeed Karimi
 * @since   0.0.1
 */
@Data
@NoArgsConstructor
public class Card implements Serializable, Cloneable {

    @NotNull
    private CardType type;

    @NotNull
    @NotEmpty
    @Size(min = 16, max = 16)
    private String pan;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String accountNumber;

    @NotNull
    @NotEmpty
    //todo: custom valid
    private String expireDate;

    @NotNull
    private CardStatus cardStatus;

    //todo: remove
    @NotNull
    Person person;

    @NotNull
    CardIssuer cardIssuer;

}

package ir.isc.BankCard.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * The {@code CardIssuer} class represents card information.
 *
 * @author  Saeed Karimi
 * @since   0.0.1
 */
@Data
@NoArgsConstructor
public class CardIssuer implements Serializable, Cloneable {

    @NotNull
    @NotEmpty
    @Size(min = 6, max = 6)
    private String code;

    @NotNull
    @NotEmpty
    private String name;

    //todo: implement toString, hash, equal and clone

}

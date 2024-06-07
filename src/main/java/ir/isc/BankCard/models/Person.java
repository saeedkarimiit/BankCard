package ir.isc.BankCard.models;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * The {@code Person} class represents card information.
 *
 * @author  Saeed Karimi
 * @since   0.0.1
 */
@Data
@NoArgsConstructor
public class Person {

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String nationalCode;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String phone;

    @NotNull
    @NotEmpty
    private String address;

    Set<Card> cards = new HashSet<>();

}

package ir.isc.BankCard.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CardDto implements Serializable {

    private Long id;

    @NotNull
    private Integer type;

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
    @Pattern(regexp = "\\d{2}/\\d{2}")
    private String expireDate;

    @NotNull
    private Integer cardStatus;

    @NotNull
    @Valid
    private PersonDto personDto;

    @NotNull
    @Valid
    private CardIssuerDto cardIssuerDto;
}

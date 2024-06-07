package ir.isc.BankCard.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CardIssuerDto implements Serializable {

    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 6, max = 6)
    private String code;

    @NotNull
    @NotEmpty
    private String name;
}

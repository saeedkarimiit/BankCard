package ir.isc.BankCard.models;

import ir.isc.BankCard.enums.CardType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssuerCardTypeModel {

    @NotNull
    @NotEmpty
    @Size(min = 6, max = 6)
    private String code;

    @NotNull
    private CardType type;

}

package ir.isc.BankCard.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class CreateCardRequestDto implements Serializable {
    @NotNull
    @NotEmpty
    @Valid
    List<CardDto> cardDtos;
}

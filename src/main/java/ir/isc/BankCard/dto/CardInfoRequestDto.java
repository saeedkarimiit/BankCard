package ir.isc.BankCard.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class CardInfoRequestDto implements Serializable {
    private List<String> nationalCodes;
    private List<String> panList;
    private List<String> accountNumbers;
}

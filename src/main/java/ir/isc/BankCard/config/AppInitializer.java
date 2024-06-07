package ir.isc.BankCard.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.isc.BankCard.dto.CardIssuerDto;
import ir.isc.BankCard.dto.CreateCardRequestDto;
import ir.isc.BankCard.services.service.CardIssuerService;
import ir.isc.BankCard.services.service.CardService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

@Configuration
@AllArgsConstructor
public class AppInitializer {

    private final CardService cardService;
    private final CardIssuerService cardIssuerService;
    private final GeneralConfigProperties generalConfigProperties;

    @PostConstruct
    private void init() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        if (generalConfigProperties.getDbEnabled()){
            List<CardIssuerDto> cardIssuerDtoList = mapper.readValue(new ClassPathResource("cardIssuers.json").getFile(), new TypeReference<>() {});
            cardIssuerService.createAll(cardIssuerDtoList);
        }
        CreateCardRequestDto cardRequestDto = mapper.readValue(new ClassPathResource("card.json").getFile(), CreateCardRequestDto.class);
        cardService.createAll(cardRequestDto);
    }
}

package ir.isc.BankCard.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "general")
@Data
public class GeneralConfigProperties {
    private Boolean dbEnabled;
}

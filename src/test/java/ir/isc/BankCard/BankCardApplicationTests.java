package ir.isc.BankCard;

import ir.isc.BankCard.dto.CardDto;
import ir.isc.BankCard.dto.CardIssuerDto;
import ir.isc.BankCard.dto.PersonDto;
import ir.isc.BankCard.services.service.CardService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankCardApplicationTests {

	@Autowired
	private CardService cardService;


	@Test
	public void addCorrectCard() throws Exception {
        CardIssuerDto mellatIssuer = new CardIssuerDto();
        mellatIssuer.setCode("222222");
        mellatIssuer.setName("Mellat");

        PersonDto personDto = new PersonDto();
        personDto.setNationalCode("2222222222");
        personDto.setName("majid");
        personDto.setLastName("majidi");
        personDto.setPhone("09122301111");
        personDto.setAddress("terhran-enghelab");

        CardDto cardDto = new CardDto();
        cardDto.setType(2);
        cardDto.setPan("8888888888888888");
        cardDto.setAccountNumber("4444444444");
        cardDto.setExpireDate("06/11");
        cardDto.setCardStatus(1);
        cardDto.setCardIssuerDto(mellatIssuer);
        cardDto.setPersonDto(personDto);

        CardDto result = cardService.create(cardDto);

        Assert.assertNotNull(result);
	}

    @Test
    public void addRepeatedCard() throws Exception {
        CardIssuerDto mellatIssuer = new CardIssuerDto();
        mellatIssuer.setCode("222222");
        mellatIssuer.setName("Mellat");

        PersonDto personDto = new PersonDto();
        personDto.setNationalCode("2222222222");
        personDto.setName("majid");
        personDto.setLastName("majidi");
        personDto.setPhone("09122301111");
        personDto.setAddress("terhran-enghelab");

        CardDto cardDto = new CardDto();
        cardDto.setType(1);
        cardDto.setPan("8888888888888888");
        cardDto.setAccountNumber("4444444444");
        cardDto.setExpireDate("06/11");
        cardDto.setCardStatus(1);
        cardDto.setCardIssuerDto(mellatIssuer);
        cardDto.setPersonDto(personDto);

        CardDto result = cardService.create(cardDto);

        Assert.assertNotNull(result);
    }

}

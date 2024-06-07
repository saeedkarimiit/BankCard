package ir.isc.BankCard;

import ir.isc.BankCard.dto.CardDto;
import ir.isc.BankCard.dto.CardIssuerDto;
import ir.isc.BankCard.dto.CreateCardRequestDto;
import ir.isc.BankCard.dto.PersonDto;
import ir.isc.BankCard.services.service.CardIssuerService;
import ir.isc.BankCard.services.service.CardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankCardApplicationTests {

	@Autowired
	private CardService cardService;

	@Autowired
	private CardIssuerService cardIssuerService;

	@Test
	public void firstTest() throws Exception {
		System.out.println("hello");
//		CreateCardRequestDto cardRequestDto = new CreateCardRequestDto();
//		List<CardDto> cardDtos = new ArrayList<>();

//		PersonDto personDto = new PersonDto();
//		personDto.setNationalCode("4679853875");
//		personDto.setName("saeed");
//		personDto.setLastName("karimi");
//		personDto.setAddress("roodaki");
//		personDto.setPhone("09015412764");

		List<CardIssuerDto> cardIssuerDtoList = new ArrayList<>();

		CardIssuerDto cardIssuerDto = new CardIssuerDto();
		cardIssuerDto.setCode("111111");
		cardIssuerDto.setName("melli");
		cardIssuerDtoList.add(cardIssuerDto);

		cardIssuerDto = new CardIssuerDto();
		cardIssuerDto.setCode("222222");
		cardIssuerDto.setName("shahr");
		cardIssuerDtoList.add(cardIssuerDto);

		cardIssuerDto = new CardIssuerDto();
		cardIssuerDto.setCode("333333");
		cardIssuerDto.setName("mellat");
		cardIssuerDtoList.add(cardIssuerDto);

		List<CardIssuerDto> result = cardIssuerService.createAll(cardIssuerDtoList);


//		CardDto cardDto = new CardDto();
//		cardDto.setPan("1234567891234567");
//		cardDto.setAccountNumber("1234567891");
//		cardDto.setType(1);
//		cardDto.setCardStatus(1);
//		cardDto.setExpireDate("08/07");
//		cardDto.setPersonDto(personDto);
//		cardDto.setCardIssuerDto(cardIssuerDto);

//		cardDtos.add(cardDto);
//
//		cardRequestDto.setCardDtos(cardDtos);

//		List<CardDto> temp = cardService.createCard(cardDto);

		System.out.println("finish");
	}

}

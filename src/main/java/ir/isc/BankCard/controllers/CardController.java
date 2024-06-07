package ir.isc.BankCard.controllers;


import io.swagger.v3.oas.annotations.Operation;
import ir.isc.BankCard.dto.CardDto;
import ir.isc.BankCard.dto.CardInfoRequestDto;
import ir.isc.BankCard.dto.CreateCardRequestDto;
import ir.isc.BankCard.services.service.CardService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/v1/card")
public class CardController {

    private final CardService cardService;

    @PostMapping("/add-card")
    @Operation(summary =  "افزودن کارت برای یک شخص")
    public ResponseEntity<CardDto> addCard(@RequestBody @Valid CardDto request) throws Exception {
        CardDto result = cardService.create(request);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/add-all-cards")
    @Operation(summary =  "افزودن چندین کارت برای اشخاص مختلف")
    public ResponseEntity<List<CardDto>> addAllCards(@RequestBody @Valid CreateCardRequestDto request) throws Exception {
        List<CardDto> result = cardService.createAll(request);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/get-all-cards")
    @Operation(summary =  "واکشی کارت های بانکی بر اساس فیلتر")
    public ResponseEntity<List<CardDto>> getAllCards(@RequestBody @Valid CardInfoRequestDto request) {
        List<CardDto> result = cardService.getAll(request);
        return CollectionUtils.isNotEmpty(result) ? ResponseEntity.ok(result) : ResponseEntity.noContent().build();
    }
}

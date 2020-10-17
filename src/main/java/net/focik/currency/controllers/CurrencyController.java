package net.focik.currency.controllers;

import lombok.AllArgsConstructor;
import net.focik.currency.dto.CurrencyResponse;
import net.focik.currency.services.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CurrencyController {

    private CurrencyService currencyService;

    @GetMapping("/currency/{currency}")
    public ResponseEntity<CurrencyResponse> getCurrency(@PathVariable String currency){
        CurrencyResponse currencyResponse=new CurrencyResponse();
        int i=0;
        try {
            currencyResponse.setValue(currencyService.getValue(currency));
            return new ResponseEntity(currencyResponse.getValue(), HttpStatus.OK);
        }catch (Exception e){
            currencyResponse.setMsgError("Nie znaleziono waluty " + currency + " w bazie danych.");
            return new ResponseEntity(currencyResponse.getMsgError(), HttpStatus.BAD_REQUEST);
        }
    }
}

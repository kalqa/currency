package net.focik.currency.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Component
public class CurrencyService {
    public double getValue(String currency) {

        Map<String,Double> currencyMap = new HashMap<>();
        currencyMap.put("PLN",3.55);
        currencyMap.put("USD",5.55);
        currencyMap.put("EUR",4.55);

        return currencyMap.get(currency);
    }
}

package mz.co.currency.DTO.response;

import lombok.Data;

import java.util.List;

@Data
public class ExchangeJson {
    private String result;
    private String dateTime;
    private String baseCurrency;
    private List<CurrencyRateJson> rates;
}

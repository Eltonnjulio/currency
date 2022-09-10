package mz.co.currency.DTO.response;

import lombok.Data;


@Data
public class CurrencyRateJson {
    private String currency;
    private Float purchase;
    private Float sale;
}

package mz.co.currency.DTO.request.create;

import lombok.Data;

@Data
public class CreateCurrencyCommand {
    private String isoCode;
    private String name;
}

package mz.co.currency.DTO.request.update;

import lombok.Data;

@Data
public class UpdateCurrencyCommand {
    private String isoCode;
    private String name;
}
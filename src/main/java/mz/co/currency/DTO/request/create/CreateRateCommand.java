package mz.co.currency.DTO.request.create;

import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class CreateRateCommand {
    private Long baseCurrencyId;
    private Long targetCurrencyId;
    private Long providerId;
    @Positive
    private Float sale;
    @Positive
    private Float purchase;
}

package mz.co.currency.DTO.request.update;

import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class UpdateRateCommand {
    @Positive
    private Float sale;
    @Positive
    private Float purchase;
}

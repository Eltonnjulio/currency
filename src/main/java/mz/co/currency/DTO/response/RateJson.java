package mz.co.currency.DTO.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RateJson {
    private Long id;
    private String baseCurrency;
    private String targetCurrency;
    private Float purchase;
    private Float sale;
    private String provider;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

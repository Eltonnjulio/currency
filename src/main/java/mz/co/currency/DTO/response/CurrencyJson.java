package mz.co.currency.DTO.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CurrencyJson {
    private Long id;
    private String name;
    private String isoCode;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

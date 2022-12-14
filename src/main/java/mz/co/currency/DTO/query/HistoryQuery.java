package mz.co.currency.DTO.query;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class HistoryQuery {
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;
}

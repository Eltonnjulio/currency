package mz.co.currency.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mz.co.currency.DTO.query.HistoryQuery;
import mz.co.currency.DTO.response.ExchangeJson;
import mz.co.currency.DTO.response.HistoryJson;
import mz.co.currency.service.HistoryService;
import mz.co.currency.service.RateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Rate History and Exchange Management")
@RequestMapping(path = "/api/v1/rates", name = "rate")
@RequiredArgsConstructor
public class RateActionsController {
    private final RateService service;
    private final HistoryService historyService;

    @GetMapping("/{baseCurrencyId}/exchange")
    @ApiOperation("Currency Rate Consult")
    public ResponseEntity<ExchangeJson> getCurrencyRates(@PathVariable Long baseCurrencyId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getBaseCurrencyRates(baseCurrencyId));
    }

    @GetMapping("/{rateId}/history")
    @ApiOperation("Currency Rate History Consult")
    public ResponseEntity<Page<HistoryJson>> getRateHistory(@PageableDefault Pageable pageable, @PathVariable Long rateId, HistoryQuery historyQuery) {
        return ResponseEntity.status(HttpStatus.OK).body(historyService.getRateHistory(pageable, historyQuery, rateId));
    }

}

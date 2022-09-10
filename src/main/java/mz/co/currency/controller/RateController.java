package mz.co.currency.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mz.co.currency.DTO.request.create.CreateRateCommand;
import mz.co.currency.DTO.request.update.UpdateRateCommand;
import mz.co.currency.DTO.response.RateJson;
import mz.co.currency.service.RateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@RestController
@Api(tags = "Rate Management")
@RequestMapping(path = "/api/v1/rates", name = "rate")
@RequiredArgsConstructor
public class RateController {
    private final RateService service;

    @GetMapping
    @ApiOperation("Fetch All Rates")
    public ResponseEntity<Page<RateJson>> getRates(@PageableDefault Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.fetchRates(pageable));
    }

    @PostMapping
    @ApiOperation("Create a new rate")
    public ResponseEntity<RateJson> createRate(@RequestBody @Valid CreateRateCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(command));
    }

    @PatchMapping("/{id}")
    @ApiOperation("Update rate values")
    public ResponseEntity<RateJson> updateDailyRate(@PathVariable Long id, @RequestBody @Valid UpdateRateCommand command) throws SQLException {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(command, id));
    }

    @GetMapping("/{id}")
    @ApiOperation("Get rate by id")
    public ResponseEntity<RateJson> getRateById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.fetchRate(id));
    }


}

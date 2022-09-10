package mz.co.currency.service;


import mz.co.currency.DTO.request.create.CreateRateCommand;
import mz.co.currency.DTO.request.update.UpdateRateCommand;
import mz.co.currency.DTO.response.ExchangeJson;
import mz.co.currency.DTO.response.RateJson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.SQLException;


public interface RateService {
    RateJson create(CreateRateCommand command);
    ExchangeJson getBaseCurrencyRates(Long baseCurrencyId);
    RateJson update(UpdateRateCommand command, Long id);
    RateJson fetchRate(Long rateId);
    Page<RateJson> fetchRates(Pageable pageable);




}

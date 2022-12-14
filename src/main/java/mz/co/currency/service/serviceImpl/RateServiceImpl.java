package mz.co.currency.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import mz.co.currency.DTO.mapper.RateMapper;
import mz.co.currency.DTO.request.create.CreateRateCommand;
import mz.co.currency.DTO.request.update.UpdateRateCommand;
import mz.co.currency.DTO.response.ExchangeJson;
import mz.co.currency.DTO.response.RateJson;
import mz.co.currency.model.Currency;
import mz.co.currency.model.History;
import mz.co.currency.model.Rate;
import mz.co.currency.repository.RateRepository;
import mz.co.currency.service.HistoryService;
import mz.co.currency.service.RateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {
    private final CurrencyServiceImpl currencyService;
    private final RateRepository repository;

   private final ProviderServiceImpl providerService;
    private final RateMapper MAPPER = RateMapper.INSTANCE;
    private final HistoryService historyService;

    @Override
    @Transactional
    public RateJson create(CreateRateCommand command) throws RuntimeException {

        Rate rate = MAPPER.mapToModel(command);
        rate.setBaseCurrency(currencyService.findById(command.getBaseCurrencyId()));
        rate.setTargetCurrency(currencyService.findById(command.getTargetCurrencyId()));
        rate.setProvider(providerService.findById(command.getProviderId()));
        rate = repository.save(rate);

        if(historyService.addHistory(new History(rate))) {
            return MAPPER.mapToJson(rate);
        }
        throw new RuntimeException("Could not create new Rate");
    }

    @Override
    public ExchangeJson getBaseCurrencyRates(Long baseCurrencyId) {
        ZonedDateTime now = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm:ss Z");
        String formatDateTime = now.format(formatter);

        ExchangeJson exchangeJson = new ExchangeJson();
        Currency currency = currencyService.findById(baseCurrencyId);
        exchangeJson.setDateTime(formatDateTime);
        exchangeJson.setBaseCurrency(currency.getIsoCode());
        exchangeJson.setResult("success");
        exchangeJson.setRates(MAPPER.mapToCurrencyJson(repository.findByBaseCurrencyId(baseCurrencyId)));
        return exchangeJson;
    }

    public Rate findByBaseCurrencyAndTargetCurrency(Long baseCurrencyId,Long targetCurrencyId){
        Rate rate = repository.findByBaseCurrencyIdAndTargetCurrencyId(baseCurrencyId,targetCurrencyId);
        if(rate != null) throw new ResponseStatusException(HttpStatus.FOUND);
        return rate;
    }

    @Override
    public RateJson update(UpdateRateCommand command, Long id) throws RuntimeException {
        Rate rate = findById(id);
        MAPPER.updateModel(rate,command);
        rate = repository.save(rate);
        if (historyService.addHistory(new History(rate))) {
            return MAPPER.mapToJson(rate);
        }
        throw new RuntimeException("Could not update rate");
    }

    @Override
    public RateJson fetchRate(Long rateId) {
        return MAPPER.mapToJson(findById(rateId));
    }

    @Override
    public Page<RateJson> fetchRates(Pageable pageable) {
        return MAPPER.mapToJson(repository.findAll(pageable));
    }



    public Rate findById(Long id){
        Rate rate = repository.findById(id).get();
        if(rate == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return rate;
    }

}

package mz.co.currency.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import mz.co.currency.DTO.mapper.CurrencyMapper;
import mz.co.currency.DTO.request.create.CreateCurrencyCommand;
import mz.co.currency.DTO.request.update.UpdateCurrencyCommand;
import mz.co.currency.DTO.response.CurrencyJson;
import mz.co.currency.model.Currency;
import mz.co.currency.repository.CurrencyRepository;
import mz.co.currency.service.CurrencyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository repository;
    private final CurrencyMapper MAPPER = CurrencyMapper.INSTANCE;
    @Override
    public CurrencyJson create(CreateCurrencyCommand command) {
        Currency currency = MAPPER.mapToModel(command);
        return MAPPER.mapToJson(repository.save(currency));
    }

    @Override
    public CurrencyJson update(UpdateCurrencyCommand command, Long id) {
        Currency currency =findById(id);
        MAPPER.updateModel(currency,command);
        return MAPPER.mapToJson(repository.save(currency));
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public CurrencyJson getById(Long id) {
        return MAPPER.mapToJson(findById(id));
    }

    @Override
    public Page<CurrencyJson> findAll(Pageable pageable) {
        return MAPPER.mapToJson(repository.findAll(pageable));
    }

    public Currency findById(Long id){
        Currency currency = repository.findById(id).get();
        if(currency == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return currency;
    }
}

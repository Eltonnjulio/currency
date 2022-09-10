package mz.co.currency.service;


import mz.co.currency.DTO.request.create.CreateCurrencyCommand;
import mz.co.currency.DTO.request.update.UpdateCurrencyCommand;
import mz.co.currency.DTO.response.CurrencyJson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CurrencyService {
    Page<CurrencyJson> findAll(Pageable pageable);
    CurrencyJson create(CreateCurrencyCommand command);
    CurrencyJson update(UpdateCurrencyCommand command, Long id);
    void deleteById(Long id);
    CurrencyJson getById(Long id);
}

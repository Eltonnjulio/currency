package mz.co.currency.service;


import mz.co.currency.DTO.query.ProviderQuery;
import mz.co.currency.DTO.request.create.CreateProviderCommand;
import mz.co.currency.DTO.request.update.UpdateProviderCommand;
import mz.co.currency.DTO.response.ProviderJson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProviderService {
    ProviderJson create(CreateProviderCommand createProviderCommand);
    ProviderJson fetchProvider(Long providerId);
    Page<ProviderJson> fetchProviders(Pageable pageable, ProviderQuery providerQuery);
    ProviderJson update(UpdateProviderCommand updateProviderCommand, Long providerId);
    void deleteById(Long providerId);
}

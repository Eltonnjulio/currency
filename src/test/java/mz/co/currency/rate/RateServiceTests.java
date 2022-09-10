package mz.co.currency.rate;

import mz.co.currency.BaseTest;
import mz.co.currency.model.Rate;
import mz.co.currency.repository.RateRepository;
import mz.co.currency.service.HistoryService;
import mz.co.currency.service.RateService;
import mz.co.currency.service.serviceImpl.CurrencyServiceImpl;
import mz.co.currency.service.serviceImpl.ProviderServiceImpl;
import mz.co.currency.service.serviceImpl.RateServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(MockitoExtension.class)
public class RateServiceTests extends BaseTest {
    private RateService underTest;
    @Mock
    private CurrencyServiceImpl currencyService;
    @Mock
    private RateRepository repository;
    @Mock
    private HistoryService historyService;
    @Mock
    private ProviderServiceImpl providerService;

    @BeforeEach
    void setUp() {
        underTest = new RateServiceImpl(currencyService, repository,providerService,historyService);
    }


    @Test
    void shouldCreateRate() {
        Mockito.when(historyService.addHistory(Mockito.any())).thenReturn(true);
        Mockito.when(repository.save(Mockito.any())).thenReturn(getAnyRate());
        underTest.create(getCreateRateCommand());
        Mockito.verify(historyService).addHistory(Mockito.any());
        Mockito.verify(repository).save(Mockito.any());
    }

}

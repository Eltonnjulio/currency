package mz.co.currency.rate;

import mz.co.currency.DTO.mapper.RateMapper;
import mz.co.currency.DTO.request.create.CreateRateCommand;
import mz.co.currency.DTO.response.RateJson;
import mz.co.currency.BaseTest;
import mz.co.currency.controller.RateController;
import mz.co.currency.model.Rate;
import mz.co.currency.service.RateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class RateControllerTests extends BaseTest {
    private RateController underTest;
    @Mock
    private RateService service;
    @BeforeEach
    void setUp() {
        underTest = new RateController(service);
    }

    @Test
    void shouldGetOneRate(){
        Rate rate = getAnyRate();
        Mockito.when(service.fetchRate(rate.getId())).thenReturn(RateMapper.INSTANCE.mapToJson(rate));
        ResponseEntity<RateJson> response = underTest.getRateById(rate.getId());

        Mockito.verify(service).fetchRate(rate.getId());
        Assertions.assertEquals(response.getBody().getId(),rate.getId());
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }


    @Test
    void shouldCreateRate(){
        CreateRateCommand command = getCreateRateCommand();
        Rate rate = getAnyRate();
        Mockito.when(service.create(command)).thenReturn(RateMapper.INSTANCE.mapToJson(rate));
        ResponseEntity<RateJson> response = underTest.createRate(command);

        Mockito.verify(service).create(command);
        Assertions.assertEquals(response.getBody().getId(),rate.getId());
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    void shouldFetchAllRates(){
        Pageable pageable = Pageable.unpaged();
        Page<RateJson> rateJsonPage = getRatePage();
        Mockito.when(service.fetchRates(pageable)).thenReturn(rateJsonPage);
        ResponseEntity<Page<RateJson>> response = underTest.getRates(pageable);

        Mockito.verify(service).fetchRates(pageable);
        Assertions.assertEquals(response.getBody(),rateJsonPage);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}

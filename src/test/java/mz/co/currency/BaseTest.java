package mz.co.currency;

import com.github.javafaker.Faker;
import mz.co.currency.DTO.mapper.RateMapper;
import mz.co.currency.DTO.request.create.CreateRateCommand;
import mz.co.currency.DTO.request.update.UpdateRateCommand;
import mz.co.currency.DTO.response.RateJson;
import mz.co.currency.model.Currency;
import mz.co.currency.model.History;
import mz.co.currency.model.Provider;
import mz.co.currency.model.Rate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.List;

public class BaseTest {
    private final Faker faker = new Faker();

    protected final Faker faker() {
        return faker;
    }


    // DTOS
    protected CreateRateCommand getCreateRateCommand() {
        CreateRateCommand command = new CreateRateCommand();
        command.setBaseCurrencyId(faker().number().randomNumber());
        command.setTargetCurrencyId(faker().number().randomNumber());
       // command.setProviderId(faker().number().randomNumber());
        command.setPurchase((float) faker().number().randomDouble(3, 1000, 10000));
        command.setSale((float) faker().number().randomDouble(3, 1000, 10000));
        return command;
    }

    protected UpdateRateCommand getUpdateRateCommand() {
        UpdateRateCommand command = new UpdateRateCommand();
        command.setPurchase((float) faker().number().randomDouble(3, 1000, 10000));
        command.setSale((float) faker().number().randomDouble(3, 1000, 10000));
        return command;
    }

    // Domains
    protected Rate getAnyRate() {
        Rate rate = new Rate();
        rate.setId(faker().number().randomNumber());
        rate.setBaseCurrency(getAnyCurrency());
        rate.setTargetCurrency(getAnyCurrency());
        rate.setPurchase((float) faker().number().randomDouble(3, 1000, 10000));
        rate.setSale((float) faker().number().randomDouble(3, 1000, 10000));
        return rate;
    }

    protected Currency getAnyCurrency() {
        Currency currency = new Currency();
        currency.setId(faker().random().nextLong());
        currency.setName(faker().currency().name());
        currency.setIsoCode(faker().currency().code());
        return currency;
    }

    protected Provider getAnyProvider() {
        Provider provider = new Provider();
        provider.setId(faker().random().nextLong());
        provider.setEmail(faker().internet().emailAddress());
        provider.setName(faker().name().fullName());
        return provider;
    }

    protected History getAnyHistory(){
        History history= new History(getAnyRate());
        history.setId(faker().random().nextLong());
        return history;
    }

    protected Page<RateJson> getRatePage() {
        return RateMapper.INSTANCE.mapToJson(new PageImpl<>(getRateList()));
    }


    protected List<Rate> getRateList() {
        return Arrays.asList(getAnyRate(), getAnyRate(), getAnyRate(), getAnyRate());
    }
}

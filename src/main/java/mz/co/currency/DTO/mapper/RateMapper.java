package mz.co.currency.DTO.mapper;


import mz.co.currency.DTO.request.create.CreateRateCommand;
import mz.co.currency.DTO.request.update.UpdateRateCommand;
import mz.co.currency.DTO.response.CurrencyRateJson;
import mz.co.currency.DTO.response.RateJson;
import mz.co.currency.model.Currency;
import mz.co.currency.model.Rate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class RateMapper {
    public static RateMapper INSTANCE = Mappers.getMapper(RateMapper.class);

    @Named("commandToModel")
    public abstract Rate mapToModel(CreateRateCommand command);

    @InheritConfiguration
    public abstract Rate mapToModel(UpdateRateCommand command);

    public abstract void updateModel(@MappingTarget Rate rate, UpdateRateCommand command);


    public abstract void cloneModel(@MappingTarget Currency currency, Currency currencySource);

    @InheritInverseConfiguration
    @Mapping(source = "baseCurrency.isoCode",target = "baseCurrency")
    @Mapping(source = "targetCurrency.isoCode",target = "targetCurrency")
    @Mapping(source = "provider.name",target = "provider")
    public abstract RateJson mapToJson(Rate currency);

    @Mapping(source = "targetCurrency.isoCode",target = "currency")
    public abstract CurrencyRateJson mapToCurrencyJson(Rate currency);
    public abstract List<CurrencyRateJson> mapToCurrencyJson(List<Rate> currency);
    public abstract List<RateJson> mapToJson(List<Rate> rates);

    public Page<RateJson> mapToJson(Page<Rate> rates) {
        return new PageImpl<>(mapToJson(rates.getContent()), rates.getPageable(), rates.getTotalElements());
    }
}

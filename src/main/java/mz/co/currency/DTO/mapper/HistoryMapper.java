package mz.co.currency.DTO.mapper;


import mz.co.currency.DTO.response.HistoryJson;
import mz.co.currency.model.History;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class HistoryMapper {
    public static HistoryMapper INSTANCE = Mappers.getMapper(HistoryMapper.class);

    @InheritInverseConfiguration
    @Mapping(source = "rate.baseCurrency.isoCode",target = "baseCurrency")
    @Mapping(source = "rate.targetCurrency.isoCode",target = "targetCurrency")
    @Mapping(source = "createdAt",target = "date")
    public abstract HistoryJson mapToJson(History history);
    public abstract List<HistoryJson> mapToJson(List<History> histories);

    public Page<HistoryJson> mapToJson(Page<History> histories) {
        return new PageImpl<>(mapToJson(histories.getContent()), histories.getPageable(), histories.getTotalElements());
    }
}

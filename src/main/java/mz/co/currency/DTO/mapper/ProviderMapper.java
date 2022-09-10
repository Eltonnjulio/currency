package mz.co.currency.DTO.mapper;

import mz.co.currency.DTO.request.create.CreateProviderCommand;
import mz.co.currency.DTO.request.update.UpdateProviderCommand;
import mz.co.currency.DTO.response.ProviderJson;
import mz.co.currency.model.Provider;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class ProviderMapper {
    public static ProviderMapper INSTANCE = Mappers.getMapper(ProviderMapper.class);

    @Named("commandToModel")
    public abstract Provider mapToModel(CreateProviderCommand command);

    @InheritConfiguration
    public abstract Provider mapToModel(UpdateProviderCommand command);

    public abstract void updateModel(@MappingTarget Provider provider, UpdateProviderCommand command);

    public abstract void cloneModel(@MappingTarget Provider provider, Provider providerSource);

    @InheritInverseConfiguration
    public abstract ProviderJson mapToJson(Provider provider);
    public abstract List<ProviderJson> mapToJson(List<Provider> providers);

    public Page<ProviderJson> mapToJson(Page<Provider> providers) {
        return new PageImpl<>(mapToJson(providers.getContent()), providers.getPageable(), providers.getTotalElements());
    }
}

package mz.co.currency.DTO.request.update;

import lombok.Data;

@Data
public class UpdateProviderCommand {
    private String name;
    private String email;
}

package edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.request.address;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.address.UpdateAddressCommand;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateAddressRequest {

    private Long id;
    private String name;
    private String description;

    public UpdateAddressCommand toCommand() {
        return UpdateAddressCommand.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();
    }

}

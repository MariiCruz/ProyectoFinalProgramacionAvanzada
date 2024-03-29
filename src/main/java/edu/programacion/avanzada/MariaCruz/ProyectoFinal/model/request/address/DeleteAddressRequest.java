package edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.request.address;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.address.DeleteAddressCommand;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteAddressRequest {

    private Long id;

    public DeleteAddressCommand toCommand() {
        return DeleteAddressCommand.builder()
                .id(id)
                .build();
    }
}

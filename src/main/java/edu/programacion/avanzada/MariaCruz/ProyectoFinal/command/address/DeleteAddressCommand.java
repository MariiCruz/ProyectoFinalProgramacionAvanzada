package edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.address;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.Command;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.adress.DeleteAddressResponse;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteAddressCommand extends Command<DeleteAddressResponse> {

    private Long id;
}

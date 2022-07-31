package edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.product;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.Command;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.product.GetProductResponse;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GetAllProductCommand extends Command<GetProductResponse> {

}

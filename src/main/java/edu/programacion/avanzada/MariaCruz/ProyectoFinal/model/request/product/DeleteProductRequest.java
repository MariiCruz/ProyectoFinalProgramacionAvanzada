package edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.request.product;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.product.DeleteProductCommand;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteProductRequest {

    private Long id;

    public DeleteProductCommand toCommand() {
        return DeleteProductCommand.builder()
                .id(id)
                .build();
    }
}

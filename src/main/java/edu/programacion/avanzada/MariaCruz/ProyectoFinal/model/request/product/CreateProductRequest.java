package edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.request.product;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.product.CreateProductCommand;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateProductRequest {

    private String name;
    private String description;
    private long availableQuantity;
    private BigDecimal price;

    public CreateProductCommand toCommand() {
        return CreateProductCommand.builder()
                .name(name)
                .description(description)
                .availableQuantity(availableQuantity)
                .price(price)
                .build();
    }
}

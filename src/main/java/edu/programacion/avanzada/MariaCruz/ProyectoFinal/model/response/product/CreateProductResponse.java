package edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.product;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.dto.ProductDTO;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateProductResponse {

    private ProductDTO product;
}

package edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.checkout;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.dto.CheckoutDTO;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckoutUpdateAddressResponse {

    private CheckoutDTO checkout;
}

package edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.payment;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.dto.PaymentMethodDTO;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdatePaymentMethodResponse {

    private PaymentMethodDTO paymentMethod;
}

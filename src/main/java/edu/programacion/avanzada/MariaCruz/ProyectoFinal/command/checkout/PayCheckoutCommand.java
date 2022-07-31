package edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.checkout;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.Command;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.saga.model.SagaPayLoadKey;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.domain.Checkout;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.domain.Order;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.checkout.PayCheckoutResponse;
import lombok.*;

import java.util.UUID;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PayCheckoutCommand extends Command<PayCheckoutResponse> {

    public static final SagaPayLoadKey<UUID> ID = new SagaPayLoadKey<>("id", UUID.class);
    public static final SagaPayLoadKey<PayCheckoutCommand> COMMAND = new SagaPayLoadKey<>("command", PayCheckoutCommand.class);
    public static final SagaPayLoadKey<Checkout> CHECKOUT = new SagaPayLoadKey<>("checkout", Checkout.class);
    public static final SagaPayLoadKey<Order> ORDER = new SagaPayLoadKey<>("order", Order.class);
    public static final SagaPayLoadKey<String> PAYMENT_INTENT = new SagaPayLoadKey<>("payment_intent", String.class);

    private UUID id;
}

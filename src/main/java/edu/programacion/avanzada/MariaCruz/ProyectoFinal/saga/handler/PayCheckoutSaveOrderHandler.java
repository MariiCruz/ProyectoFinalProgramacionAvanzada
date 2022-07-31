package edu.programacion.avanzada.MariaCruz.ProyectoFinal.saga.handler;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.checkout.PayCheckoutCommand;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.domain.Order;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.checkout.PayCheckoutResponse;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.saga.model.SagaPayload;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author aluis on 7/24/2022.
 */
@RequiredArgsConstructor
@Component
public class PayCheckoutSaveOrderHandler implements SagaStepHandler<PayCheckoutResponse> {

    private final OrderRepository orderRepository;

    @Override
    public void handle(SagaPayload<PayCheckoutResponse> sagaPayload) {
        Order order = sagaPayload.getProperty(PayCheckoutCommand.ORDER);
        orderRepository.save(order);
    }
}

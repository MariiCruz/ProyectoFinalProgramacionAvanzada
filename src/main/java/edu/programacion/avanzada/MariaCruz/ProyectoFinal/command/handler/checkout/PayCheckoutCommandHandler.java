package edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.handler.checkout;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.saga.SagaOrchestrator;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.saga.model.Saga;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.saga.SagaFactory;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.checkout.PayCheckoutCommand;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.checkout.PayCheckoutResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author aluis on 7/10/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = PayCheckoutCommand.class)
@Slf4j
public class PayCheckoutCommandHandler implements CommandHandler<PayCheckoutResponse, PayCheckoutCommand> {

    private final SagaOrchestrator sagaOrchestrator;

    @Value("${pattern.saga.timeout}")
    private int timeout;

    @Override
    public PayCheckoutResponse handle(PayCheckoutCommand payCheckoutCommand) {
        Saga<PayCheckoutResponse> saga = SagaFactory.payCheckoutSaga(UUID.randomUUID(), payCheckoutCommand);
        return sagaOrchestrator.orchestrate(saga, timeout);
    }
}

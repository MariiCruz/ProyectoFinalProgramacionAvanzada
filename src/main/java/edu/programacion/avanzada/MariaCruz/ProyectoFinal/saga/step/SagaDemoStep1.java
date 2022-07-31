package edu.programacion.avanzada.MariaCruz.ProyectoFinal.saga.step;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.DemoResponse;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.saga.model.SagaPayLoadKey;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.saga.model.SagaStep;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.saga.model.SagaStepCompensator;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author aluis on 7/17/2022.
 */
@Component
@Slf4j
public class SagaDemoStep1 implements SagaStep<DemoResponse> {

    @Override
    public String getName() {
        return "Demo Step 1";
    }

    @Override
    public SagaStepHandler<DemoResponse> getHandler() {
        return sagaPayload -> {
            log.info("Running {} Handler", getName());
            System.out.println("Testing Demo Handler");
            sagaPayload.addProperty(new SagaPayLoadKey<>("decimal", BigDecimal.class), new BigDecimal(500));
        };
    }

    @Override
    public SagaStepCompensator<DemoResponse> getCompensator() {
        return sagaPayload -> {
            log.info("Running {} compensator", getName());
            log.info("Fallando epicamente!");
        };
    }
}

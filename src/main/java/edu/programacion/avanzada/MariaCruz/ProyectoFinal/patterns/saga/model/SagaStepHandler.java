package edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.saga.model;

public interface SagaStepHandler<T> {

    void handle(SagaPayload<T> sagaPayload);
}

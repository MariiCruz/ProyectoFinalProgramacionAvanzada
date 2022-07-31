package edu.programacion.avanzada.MariaCruz.ProyectoFinal.services;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.DemoCommand;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.DemoResponse;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author aluis on 7/17/2022.
 */
@RequiredArgsConstructor
@Service
public class DemoService {

    private final CommandBus commandBus;

    public DemoResponse get(boolean explote) {
        return commandBus.sendCommand(DemoCommand.builder().explote(explote).build());
    }
}

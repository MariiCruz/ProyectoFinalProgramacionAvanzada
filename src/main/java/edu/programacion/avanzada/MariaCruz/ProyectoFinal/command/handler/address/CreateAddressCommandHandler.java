package edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.handler.address;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.repositories.AddressRepository;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.address.CreateAddressCommand;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.domain.Address;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.adress.CreateAddressResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aluis on 7/10/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = CreateAddressCommand.class)
@Slf4j
public class CreateAddressCommandHandler implements CommandHandler<CreateAddressResponse, CreateAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public CreateAddressResponse handle(CreateAddressCommand createAddressCommand) {
        Address address = addressRepository.save(createAddressCommand.toAddress());
        log.info("Address {} created", address.getId());
        return CreateAddressResponse.builder()
                .address(address.toDTO())
                .build();
    }
}

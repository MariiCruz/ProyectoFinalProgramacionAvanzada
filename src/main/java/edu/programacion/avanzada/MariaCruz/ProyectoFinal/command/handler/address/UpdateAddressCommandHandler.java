package edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.handler.address;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.repositories.AddressRepository;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.address.UpdateAddressCommand;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.domain.Address;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.exceptions.AddressNoFoundException;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.adress.UpdateAddressResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aluis on 7/10/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = UpdateAddressCommand.class)
@Slf4j
public class UpdateAddressCommandHandler implements CommandHandler<UpdateAddressResponse, UpdateAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public UpdateAddressResponse handle(UpdateAddressCommand updateAddressCommand) {
        Address address = addressRepository.findById(updateAddressCommand.getId()).orElseThrow(() -> new AddressNoFoundException(updateAddressCommand.getId()));
        address.setName(updateAddressCommand.getName());
        address.setDescription(updateAddressCommand.getDescription());
        addressRepository.save(address);
        log.info("Address {} updated", updateAddressCommand.getId());
        return UpdateAddressResponse.builder().address(address.toDTO()).build();
    }
}

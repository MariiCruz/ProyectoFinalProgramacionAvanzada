package edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.handler.address;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.dto.AddressDTO;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.repositories.AddressRepository;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.address.GetAllAddressCommand;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.domain.Address;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.adress.GetAddressResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aluis on 7/10/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = GetAllAddressCommand.class)
@Slf4j
public class GetAllAddressCommandHandler implements CommandHandler<GetAddressResponse, GetAllAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public GetAddressResponse handle(GetAllAddressCommand getAllAddressCommand) {
        log.debug("Get Addresses {}", getAllAddressCommand.toString());
        List<AddressDTO> addressDTOS = addressRepository.findAllByNameContainingIgnoreCase(
                        getAllAddressCommand.getName(),
                        PageRequest.of(getAllAddressCommand.getPage(), getAllAddressCommand.getPageSize()))
                .stream()
                .map(Address::toDTO)
                .collect(Collectors.toList());
        return GetAddressResponse.builder()
                .addresses(addressDTOS)
                .build();
    }
}

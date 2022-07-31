package edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.handler;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.address.DeleteAddressCommand;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.handler.address.DeleteAddressCommandHandler;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.adress.DeleteAddressResponse;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.repositories.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author aluis on 7/10/2022.
 */
@SpringBootTest
class DeleteAddressCommandHandlerTest {

    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    void setup() {
    }

    @Test
    void deleteAddressTest() {
        DeleteAddressCommand deleteAddressCommand = DeleteAddressCommand.builder()
                .id(1L)
                .build();
        Mockito.doNothing().when(addressRepository).deleteById(ArgumentMatchers.eq(1L));
        DeleteAddressCommandHandler deleteAddressCommandHandler = new DeleteAddressCommandHandler(addressRepository);
        DeleteAddressResponse deleteAddressResponse = deleteAddressCommandHandler.handle(deleteAddressCommand);
        assertNotNull(deleteAddressResponse);
    }

}
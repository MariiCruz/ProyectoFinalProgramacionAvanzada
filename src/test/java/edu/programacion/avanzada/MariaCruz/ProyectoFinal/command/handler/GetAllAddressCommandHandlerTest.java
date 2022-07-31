package edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.handler;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.dto.AddressDTO;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.address.GetAllAddressCommand;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.handler.address.GetAllAddressCommandHandler;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.domain.Address;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.adress.GetAddressResponse;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.repositories.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author aluis on 7/10/2022.
 */
@SpringBootTest
class GetAllAddressCommandHandlerTest {

    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    void setup() {
    }

    @Test
    void getAllAddressTest() {
        Address addressMock = Mockito.spy(Address.class);
        addressMock.setId(1L);
        addressMock.setName("Hello");
        addressMock.setDescription("");
        GetAllAddressCommand getAllAddressCommand = GetAllAddressCommand.builder()
                .name("")
                .pageSize(10)
                .page(0)
                .build();
        Mockito.when(addressRepository.findAllByNameContainingIgnoreCase(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(List.of(addressMock));
        GetAllAddressCommandHandler getAllAddressCommandHandler = new GetAllAddressCommandHandler(addressRepository);
        GetAddressResponse getAddressResponse = getAllAddressCommandHandler.handle(getAllAddressCommand);
        assertNotNull(getAddressResponse);
        List<AddressDTO> addresses = getAddressResponse.getAddresses();
        assertNotNull(addresses);
        assertFalse(addresses.isEmpty());
        assertEquals(1, addresses.size());
        AddressDTO address = addresses.get(0);
        assertEquals(addressMock.getId(), address.getId());
        assertEquals(addressMock.getName(), address.getName());
        assertEquals(addressMock.getDescription(), address.getDescription());
    }

}
package edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.adress;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.dto.AddressDTO;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateAddressResponse {

    private AddressDTO address;
}

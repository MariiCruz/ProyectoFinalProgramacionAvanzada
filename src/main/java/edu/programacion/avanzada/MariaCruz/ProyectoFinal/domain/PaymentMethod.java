package edu.programacion.avanzada.MariaCruz.ProyectoFinal.domain;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.dto.PaymentMethodDTO;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.request.payment.UpdatePaymentMethodRequest;
import lombok.*;

import javax.persistence.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "payment_methods")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    public PaymentMethodDTO toDTO() {
        return PaymentMethodDTO.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();
    }

    public void applyChanges(UpdatePaymentMethodRequest updatePaymentMethodRequest) {
        description = updatePaymentMethodRequest.getDescription();
    }
}

package edu.programacion.avanzada.MariaCruz.ProyectoFinal.repositories;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.domain.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author aluis on 7/10/2022.
 */
@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}

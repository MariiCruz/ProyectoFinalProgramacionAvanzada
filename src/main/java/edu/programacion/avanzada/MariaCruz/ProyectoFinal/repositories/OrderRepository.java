package edu.programacion.avanzada.MariaCruz.ProyectoFinal.repositories;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author aluis on 7/10/2022.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
}

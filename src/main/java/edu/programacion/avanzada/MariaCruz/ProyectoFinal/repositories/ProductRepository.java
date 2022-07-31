package edu.programacion.avanzada.MariaCruz.ProyectoFinal.repositories;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.domain.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author aluis on 7/10/2022.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}

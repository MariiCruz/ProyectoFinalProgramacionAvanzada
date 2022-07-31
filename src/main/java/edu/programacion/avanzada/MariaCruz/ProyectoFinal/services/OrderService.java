package edu.programacion.avanzada.MariaCruz.ProyectoFinal.services;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.dto.OrderDTO;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.repositories.OrderRepository;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author aluis on 7/10/2022.
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(Order::toDTO).collect(Collectors.toList());
    }

    public OrderDTO get(UUID id) {
        return orderRepository.findById(id).orElseThrow().toDTO();
    }
}

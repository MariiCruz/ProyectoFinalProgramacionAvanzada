package edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.handler.product;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.product.GetAllProductCommand;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.dto.ProductDTO;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.repositories.ProductRepository;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.domain.Product;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.product.GetProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aluis on 7/10/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = GetAllProductCommand.class)
@Slf4j
public class GetAllProductCommandHandler implements CommandHandler<GetProductResponse, GetAllProductCommand> {

    private final ProductRepository productRepository;

    @Override
    public GetProductResponse handle(GetAllProductCommand getAllProductCommand) {
        log.debug("Get Products {}", getAllProductCommand.toString());
        List<ProductDTO> productDTOS = productRepository.findAll()
                .stream()
                .map(Product::toDTO)
                .collect(Collectors.toList());
        return GetProductResponse.builder()
                .products(productDTOS)
                .build();
    }
}

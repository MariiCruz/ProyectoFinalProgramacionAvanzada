package edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.handler.product;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.product.GetProductCommand;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.dto.ProductDTO;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.repositories.ProductRepository;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.product.GetProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author aluis on 7/10/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = GetProductCommand.class)
@Slf4j
public class GetProductCommandHandler implements CommandHandler<GetProductResponse, GetProductCommand> {

    private final ProductRepository productRepository;

    @Override
    public GetProductResponse handle(GetProductCommand getProductCommand) {
        log.debug("Get Product {}", getProductCommand.getId());
        ProductDTO productDTO = productRepository.findById(getProductCommand.getId()).orElseThrow().toDTO();
        return GetProductResponse.builder()
                .products(List.of(productDTO))
                .build();
    }
}

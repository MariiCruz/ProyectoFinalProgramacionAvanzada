package edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.handler.product;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.product.CreateProductCommand;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.repositories.ProductRepository;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.domain.Product;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.product.CreateProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aluis on 7/10/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = CreateProductCommand.class)
@Slf4j
public class CreateProductCommandHandler implements CommandHandler<CreateProductResponse, CreateProductCommand> {

    private final ProductRepository productRepository;

    @Override
    public CreateProductResponse handle(CreateProductCommand createProductCommand) {
        Product product = productRepository.save(createProductCommand.toProduct());
        log.info("Product {} created", product.getId());
        return CreateProductResponse.builder()
                .product(product.toDTO())
                .build();
    }
}

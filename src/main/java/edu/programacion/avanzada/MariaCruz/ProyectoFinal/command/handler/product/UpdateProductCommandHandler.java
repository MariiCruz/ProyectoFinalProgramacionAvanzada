package edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.handler.product;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.product.UpdateProductCommand;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.repositories.ProductRepository;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.domain.Product;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.product.UpdateProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aluis on 7/10/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = UpdateProductCommand.class)
@Slf4j
public class UpdateProductCommandHandler implements CommandHandler<UpdateProductResponse, UpdateProductCommand> {

    private final ProductRepository productRepository;

    @Override
    public UpdateProductResponse handle(UpdateProductCommand updateProductCommand) {
        Product product = productRepository.findById(updateProductCommand.getId()).orElseThrow();
        product.setAvailableQuantity(updateProductCommand.getAvailableQuantity());
        product.setDescription(updateProductCommand.getDescription());
        product.setPrice(updateProductCommand.getPrice());
        productRepository.save(product);
        log.info("Product {} updated", updateProductCommand.getId());
        return UpdateProductResponse.builder().product(product.toDTO()).build();
    }
}

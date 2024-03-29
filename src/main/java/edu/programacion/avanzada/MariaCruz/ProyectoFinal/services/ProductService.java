package edu.programacion.avanzada.MariaCruz.ProyectoFinal.services;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.request.product.CreateProductRequest;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.request.product.DeleteProductRequest;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.request.product.UpdateProductRequest;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.product.GetAllProductCommand;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.command.product.GetProductCommand;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.product.CreateProductResponse;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.product.DeleteProductResponse;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.product.GetProductResponse;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.product.UpdateProductResponse;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author aluis on 7/10/2022.
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final CommandBus commandBus;

    public GetProductResponse getAll() {
        return commandBus.sendCommand(GetAllProductCommand.builder().build());
    }

    public GetProductResponse get(Long id) {
        return commandBus.sendCommand(GetProductCommand.builder().id(id).build());
    }

    public CreateProductResponse create(CreateProductRequest createProductRequest) {
        return commandBus.sendCommand(createProductRequest.toCommand());
    }

    public UpdateProductResponse update(UpdateProductRequest updateProductRequest) {
        return commandBus.sendCommand(updateProductRequest.toCommand());
    }

    public DeleteProductResponse delete(DeleteProductRequest deleteProductRequest) {
        return commandBus.sendCommand(deleteProductRequest.toCommand());
    }
}

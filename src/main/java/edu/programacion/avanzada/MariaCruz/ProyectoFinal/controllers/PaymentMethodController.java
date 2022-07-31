package edu.programacion.avanzada.MariaCruz.ProyectoFinal.controllers;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.request.payment.CreatePaymentMethodRequest;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.request.payment.DeletePaymentMethodRequest;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.request.payment.UpdatePaymentMethodRequest;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.payment.CreatePaymentMethodResponse;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.payment.DeletePaymentMethodResponse;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.payment.GetPaymentMethodResponse;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.payment.UpdatePaymentMethodResponse;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.services.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author aluis on 7/10/2022.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/payment/methods")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @GetMapping
    public ResponseEntity<GetPaymentMethodResponse> get() {
        return ResponseEntity.ok(GetPaymentMethodResponse.builder()
                .paymentMethods(paymentMethodService.getAll())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPaymentMethodResponse> get(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(GetPaymentMethodResponse.builder()
                .paymentMethods(List.of(paymentMethodService.get(id)))
                .build());
    }

    @PostMapping
    public ResponseEntity<CreatePaymentMethodResponse> create(@Valid @RequestBody CreatePaymentMethodRequest createPaymentMethodRequest) {
        return ResponseEntity.ok(CreatePaymentMethodResponse.builder()
                .paymentMethod(paymentMethodService.create(createPaymentMethodRequest))
                .build());
    }

    @PutMapping
    public ResponseEntity<UpdatePaymentMethodResponse> update(@Valid @RequestBody UpdatePaymentMethodRequest updatePaymentMethodRequest) {
        return ResponseEntity.ok(UpdatePaymentMethodResponse.builder()
                .paymentMethod(paymentMethodService.update(updatePaymentMethodRequest))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<DeletePaymentMethodResponse> delete(@Valid @RequestBody DeletePaymentMethodRequest deleteEmployeeRequest) {
        paymentMethodService.delete(deleteEmployeeRequest);
        return ResponseEntity.ok(DeletePaymentMethodResponse.builder().build());
    }
}

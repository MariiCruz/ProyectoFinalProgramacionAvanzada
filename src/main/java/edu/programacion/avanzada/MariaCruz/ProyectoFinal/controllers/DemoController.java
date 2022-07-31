package edu.programacion.avanzada.MariaCruz.ProyectoFinal.controllers;

import edu.programacion.avanzada.MariaCruz.ProyectoFinal.model.response.DemoResponse;
import edu.programacion.avanzada.MariaCruz.ProyectoFinal.services.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aluis on 7/17/2022.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/demo")
public class DemoController {

    private final DemoService demoService;

    @GetMapping
    public ResponseEntity<DemoResponse> get(@RequestParam(defaultValue = "0") String explote) {
        return ResponseEntity.ok(demoService.get(explote.equals("1")));
    }
}

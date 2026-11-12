package com.smartlibrary.controller;

import com.smartlibrary.dto.PrestamoRequest;
import com.smartlibrary.dto.PrestamoResponse;
import com.smartlibrary.model.Prestamo;
import com.smartlibrary.service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping
    public ResponseEntity<PrestamoResponse> registrar(@Valid @RequestBody PrestamoRequest request) {
        Prestamo p = prestamoService.registrarPrestamo(request.estudianteId(), request.libroId());
        return ResponseEntity.status(HttpStatus.CREATED).body(PrestamoResponse.desde(p));
    }

    @GetMapping
    public ResponseEntity<List<PrestamoResponse>> listar() {
        List<PrestamoResponse> prestamos = prestamoService.listarPrestamos().stream()
                .map(PrestamoResponse::desde)
                .toList();
        return ResponseEntity.ok(prestamos);
    }
}

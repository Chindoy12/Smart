package com.smartlibrary.dto;

import com.smartlibrary.model.Prestamo;

import java.time.LocalDate;

public record PrestamoResponse(
        Long id,
        String estudiante,
        String libro,
        LocalDate fechaPrestamo
) {

    public static PrestamoResponse desde(Prestamo p) {
        return new PrestamoResponse(
                p.getId(),
                p.getEstudiante().getNombre(),
                p.getLibro().getTitulo(),
                p.getFechaPrestamo()
        );
    }
}

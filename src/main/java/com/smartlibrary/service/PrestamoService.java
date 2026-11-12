package com.smartlibrary.service;

import com.smartlibrary.model.Estudiante;
import com.smartlibrary.model.Libro;
import com.smartlibrary.model.Prestamo;
import com.smartlibrary.repository.EstudianteRepository;
import com.smartlibrary.repository.LibroRepository;
import com.smartlibrary.repository.PrestamoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final LibroRepository libroRepository;
    private final EstudianteRepository estudianteRepository;

    public PrestamoService(PrestamoRepository prestamoRepo,
        LibroRepository libroRepo,
        EstudianteRepository estudianteRepo) {
        this.prestamoRepository = prestamoRepo;
        this.libroRepository = libroRepo;
        this.estudianteRepository = estudianteRepo;
    }

    @Transactional
    public Prestamo registrarPrestamo(Long estudianteId, Long libroId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Estudiante no encontrado: " + estudianteId));

        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Libro no encontrado: " + libroId));

        boolean disponible = libro.isDisponible();
        boolean tieneActivo = prestamoRepository.existsByLibroIdAndFechaDevolucionIsNull(libroId);
        if (!disponible || tieneActivo) {
            throw new LibroNoDisponibleException("El libro no está disponible: " + libroId);
        }

        libro.marcarPrestado();
        Prestamo p = new Prestamo(estudiante, libro, LocalDate.now());
        p = prestamoRepository.save(p);
        libroRepository.save(libro);
        return p;
    }

    @Transactional(readOnly = true)
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }
}

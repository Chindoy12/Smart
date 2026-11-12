package com.smartlibrary.repository;

import com.smartlibrary.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * save(prestamo): Prestamo y findAll(): List&lt;Prestamo&gt; se heredan de JpaRepository.
 */
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    boolean existsByLibroIdAndFechaDevolucionIsNull(Long libroId);
}

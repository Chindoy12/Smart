package com.smartlibrary.repository;

import com.smartlibrary.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * findById(id): Optional&lt;Libro&gt; y save(libro): Libro se heredan de JpaRepository.
 */
public interface LibroRepository extends JpaRepository<Libro, Long> {
}

package com.smartlibrary.repository;

import com.smartlibrary.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * findById(id): Optional&lt;Estudiante&gt; se hereda de JpaRepository.
 */
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}

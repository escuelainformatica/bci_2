package com.cursobci.alumnos.repositorio;

import com.cursobci.alumnos.modelo.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno, Integer> {

    /**
     * Inserta un alumno con un id explicito (cuando el id no existe en la tabla).
     * Necesario porque la clave es IDENTITY y Hibernate autogenera los ids en save().
     */
    @Modifying
    @Query(value = "INSERT INTO alumnos (id, nombre, edad) VALUES (:id, :nombre, :edad)", nativeQuery = true)
    int insertarConId(@Param("id") Integer id, @Param("nombre") String nombre, @Param("edad") Integer edad);
}


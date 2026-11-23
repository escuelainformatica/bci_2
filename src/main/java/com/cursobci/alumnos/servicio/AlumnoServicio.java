package com.cursobci.alumnos.servicio;

import com.cursobci.alumnos.modelo.Alumno;
import com.cursobci.alumnos.repositorio.AlumnoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlumnoServicio {

    private final AlumnoRepositorio alumnoRepositorio;

    public AlumnoServicio(AlumnoRepositorio alumnoRepositorio) {
        this.alumnoRepositorio = alumnoRepositorio;
    }

    public List<Alumno> listar() {
        return alumnoRepositorio.findAll();
    }

    @Transactional
    public Alumno insertar(Alumno alumno) {
        if (alumno.getId() == null || alumnoRepositorio.existsById(alumno.getId())) {
            // Sin id: INSERT con id autogenerado / Id existente: UPDATE
            return alumnoRepositorio.save(alumno);
        }
        // Id proporcionado y libre: INSERT con ese id exacto
        alumnoRepositorio.insertarConId(alumno.getId(), alumno.getNombre(), alumno.getEdad());
        return alumno;
    }
}


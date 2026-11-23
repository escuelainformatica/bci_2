package com.cursobci.alumnos.controlador;

import com.cursobci.alumnos.modelo.Alumno;
import com.cursobci.alumnos.servicio.AlumnoServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlumnoControlador {

    private final AlumnoServicio alumnoServicio;

    public AlumnoControlador(AlumnoServicio alumnoServicio) {
        this.alumnoServicio = alumnoServicio;
    }

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("alumnos", alumnoServicio.listar());
        return "alumnos";
    }

    @GetMapping("/insertar")
    public String insertar(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "insertar";
    }

    @PostMapping("/insertar")
    public String insertar(@ModelAttribute Alumno alumno) {
        alumnoServicio.insertar(alumno);
        return "redirect:/";
    }
}

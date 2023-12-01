package com.puce.practica1.controller;
//cuarto el controlador
import java.util.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

//modelo y servicio
import com.puce.practica1.model.Empleado;
import com.puce.practica1.service.EmpleadoService;

@RestController
@RequestMapping("/api/v1/empleados")

public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public Empleado agregarEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.saveEmpleado(empleado);
    }

    @DeleteMapping("/{id}")
    public String deleteEmpleado(@PathVariable int empleado) {
        return empleadoService.deleteEmpleado(empleado);
    }

    @PutMapping
    public Empleado updateEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.updateEmpleado(empleado);
    }
    @GetMapping
    public List<Empleado> getEmpleados() {
        return empleadoService.getEmpleados();
    }
    @GetMapping("/{id}")
    public Empleado buscar (@PathVariable int id){
        return empleadoService.getEmpleadoById(id);
    }
    
}

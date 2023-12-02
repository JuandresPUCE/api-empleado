package com.puce.practica1.controller;
//cuarto el controlador
import java.util.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    public ResponseEntity<String> deleteEmpleado(@PathVariable int id) {
    try {
        String result = empleadoService.deleteEmpleado(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>("Error al eliminar el empleado: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    /* 
    @DeleteMapping("/{id}")
    public String deleteEmpleado(@PathVariable int empleado) {
        return empleadoService.deleteEmpleado(empleado);
    }*/

    @PutMapping("/{id}")
    public Empleado updateEmpleado(@RequestBody Empleado empleado) {
    return empleadoService.updateEmpleado(empleado);}
    
    @GetMapping
    public List<Empleado> getEmpleados() {
        return empleadoService.getEmpleados();
    }
    @GetMapping("/{id}")
    //http://localhost:8080/api/v1/empleados/3
    public Empleado buscar (@PathVariable int id){
        return empleadoService.getEmpleadoById(id);
    }
    
    
    //busca por email
    //http://localhost:8080/api/v1/empleados/por-email?email=juan.perez@example.com
    // En el controlador
    @GetMapping("/por-email")
    public List<Empleado> buscarPorEmail(@RequestParam String email) {
    return empleadoService.listarPorEmail(email);
    }

    

    @GetMapping("/sueldo-mayor-a-1000")
    //solo mayores a 1000
    //http://localhost:8080/api/v1/empleados/sueldo-mayor-a-1000
    public ResponseEntity<List<Empleado>> listarSueldoMayorA1000() {
        List<Empleado> empleados = empleadoService.listarSueldoMayorA1000();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @GetMapping("/experiencia-mayor-a-5-anios")
    //solo mayores a 5 años
    //http://localhost:8080/api/v1/empleados/experiencia-mayor-a-5-anios
    public ResponseEntity<List<Empleado>> listarExperienciaMayorA5Anios() {
        List<Empleado> empleados = empleadoService.listarExperienciaMayorA5Anios();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }
}

package com.puce.practica1.service;
//tercero el servicio
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import org.springframework.stereotype.*;


//importar el modelo
import com.puce.practica1.model.Empleado;
//importar el repositorio
import com.puce.practica1.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
    
    @Autowired
    private EmpleadoRepository empleadoRepository;
    public Empleado saveEmpleado (Empleado empleado){
        return empleadoRepository.save(empleado);
    }
    public List<Empleado> getEmpleados(){
        return empleadoRepository.getAllEmpleados();
    }
    public String deleteEmpleado(int id) {
        return empleadoRepository.delete(id);
    }

    public Empleado updateEmpleado (Empleado empleado){
        return empleadoRepository.update(empleado);
    }

    public Empleado getEmpleadoById(int id){
        return empleadoRepository.findById(id);
    }

    public List<Empleado> listarPorEmail(String email) {
        return empleadoRepository.findByEmail(email);
    }

    public List<Empleado> listarSueldoMayorA1000() {
        return empleadoRepository.findBySueldoGreaterThan(1000.0);
    }

    public List<Empleado> listarExperienciaMayorA5Anios() {
        return empleadoRepository.findByAniosExperienciaGreaterThan(5);
    }


    
}

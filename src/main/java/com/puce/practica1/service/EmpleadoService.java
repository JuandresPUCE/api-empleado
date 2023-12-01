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
    public String deleteEmpleado (int empleado){
        return empleadoRepository.delete(empleado);
    }

    public Empleado updateEmpleado (Empleado empleado){
        return empleadoRepository.update(empleado);
    }

    public Empleado getEmpleadoById(int id){
        return empleadoRepository.findById(id);
    }


    
}

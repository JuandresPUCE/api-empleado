package com.puce.practica1.repository;
//segundo el repositorio
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.*;

//importar el modelo
import com.puce.practica1.model.Empleado;

@Repository
public class EmpleadoRepository {
    private List<Empleado> empleados = new ArrayList<>();
    public List<Empleado> getAllEmpleados() {
        return empleados;
    }

    public Empleado findById(int id) {
        for (int i=0; i<empleados.size(); i++) {
            if (empleados.get(i).getId() == id) {
                return empleados.get(i);
            }
        }
        return null;
    }

    public Empleado save(Empleado e) {
        Empleado empleado = new Empleado();
        empleado.setId(e.getId());
        empleado.setNombre(e.getNombre());
        empleado.setApellido(e.getApellido());
        empleado.setEmail(e.getEmail());
        empleado.setEdad(e.getEdad());
        empleado.setSueldo(e.getSueldo());
        empleado.setAniosExperiencia(e.getAniosExperiencia());
        empleado.setTelefono(e.getTelefono());
        empleados.add(empleado);
        return empleado;
    }


    public String delete(int id) {
        empleados.removeIf(empleado -> empleado.getId() == id);
        return "Empleado eliminado con éxito";
    }


    public Empleado update (Empleado empleado){
        
        int idPos =0;

        for (int i=0; i<empleados.size(); i++) {
            if (empleados.get(i).getId() == empleado.getId()) {
                idPos = i;
                break;
            }
        }
        Empleado empleadoact = new Empleado();
        empleadoact.setId(empleado.getId());
        empleadoact.setNombre(empleado.getNombre());
        empleadoact.setApellido(empleado.getApellido());
        empleadoact.setEmail(empleado.getEmail());
        empleadoact.setEdad(empleado.getEdad());
        empleadoact.setSueldo(empleado.getSueldo());
        empleadoact.setAniosExperiencia(empleado.getAniosExperiencia());
        empleadoact.setTelefono(empleado.getTelefono());
        empleados.set(idPos, empleadoact);
        return empleadoact;

    }

        public List<Empleado> findBySueldoGreaterThan(double sueldo) {
        return empleados.stream()
            .filter(e -> e.getSueldo() > sueldo)
            .collect(Collectors.toList());
    }
    public List<Empleado> findByAniosExperienciaGreaterThan(int aniosExperiencia) {
        return empleados.stream()
            .filter(e -> e.getAniosExperiencia() > aniosExperiencia)
            .collect(Collectors.toList());
    }
    public List<Empleado> findByEmail(String email) {
        return empleados.stream()
            .filter(e -> e.getEmail().equalsIgnoreCase(email))
            .collect(Collectors.toList());
    }

}

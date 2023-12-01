package com.puce.practica1.repository;
//segundo el repositorio
import java.util.*;
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
        empleado.setEdad(e.getEdad());
        empleado.setSueldo(e.getSueldo());
        empleado.setAniosExperiencia(e.getAniosExperiencia());
        empleado.setTelefono(e.getTelefono());
        empleados.add(empleado);
        return empleado;
    }

    public String delete (int id){
        empleados.removeIf(empleado -> empleado.getId() == id);
        return null;
    }

    public Empleado update (Empleado empleado){
        int id = 0;
        int idPos =0;

        for (int i=0; i<empleados.size(); i++) {
            if (empleados.get(i).getId() == empleado.getId()) {
                idPos = i;
                break;
            }
        }
        Empleado empleadoact = new Empleado();
        empleadoact.setId(id);
        empleadoact.setNombre(empleado.getNombre());
        empleadoact.setApellido(empleado.getApellido());
        empleadoact.setEdad(empleado.getEdad());
        empleadoact.setSueldo(empleado.getSueldo());
        empleadoact.setAniosExperiencia(empleado.getAniosExperiencia());
        empleadoact.setTelefono(empleado.getTelefono());
        empleados.set(idPos, empleadoact);
        return empleadoact;

    }

}

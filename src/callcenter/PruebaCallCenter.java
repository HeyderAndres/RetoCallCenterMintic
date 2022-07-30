package callcenter;

import clases.CallCenter;
import clases.Empleado;
import java.util.ArrayList;
import model.ModelEmpleado;
import model.dbData;

public class PruebaCallCenter {

    public static void main(String[] args) {
        
        ModelEmpleado empleado1 = new ModelEmpleado();
        empleado1.consultaEmpleadoId("3");

               
        // TODO code application logic here
       ArrayList<Empleado> empleados = new ArrayList<>();
        
        CallCenter callCenter = new  CallCenter();
        System.out.println(callCenter.liquidarNominaEmp(empleados));
        /* 
        Empleado empleado1 = new Empleado("Carmen", 40000, true, 1500000);
        empleados.add(empleado1); */
        
        //Empleado empleado2 = new Empleado("5", "hola", "mundo", 150, true, 20000);
        //empleados.add(empleado2);
        
      /*  Empleado empleado3 = new Empleado("Carmen", 50000, false, 2000000);
        empleados.add(empleado3);*/
        
        System.out.println(callCenter.liquidarNominaEmp(empleados));
       
    }
    
}

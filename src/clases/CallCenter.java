package clases;

import java.util.ArrayList;

public class CallCenter {
    ArrayList<Empleado> Empleados = new ArrayList<>();

    public void setEmpleados(ArrayList<Empleado> Empleados) {
        this.Empleados = Empleados;
    }

    public ArrayList<Empleado> getEmpleados() {
        return Empleados;
    }
    
    public ArrayList<Double> liquidarNominaEmp(ArrayList<Empleado> empleados){
        ArrayList<Double> nominas = new ArrayList<>();
        if (empleados == null) {
            return null;
        }
        for (Empleado empleado : empleados) {
            double aportes = (empleado.getHorasExtra()+empleado.getSalario())*0.08;
            double neto = empleado.getHorasExtra()+empleado.getSalario();
            if (empleado.isAuxilioTransporte()) {
                nominas.add(neto+106454-aportes);
            }else{
                nominas.add(neto-aportes);
            }
        }
        return nominas;
    }
    
    public ArrayList<Double> liquidarPrestacionesemp(ArrayList<Empleado> empleados){
    ArrayList<Double> prestaciones = new ArrayList<>();
    
    if(empleados == null){
        return null;
    }
    
        for (Empleado empleado : empleados) {
            double valorPrestaciones,  primas, cesantias, interesCesantias, vacaciones;
            int valorAuxilioTransporte = 106454;
            double valorHoraExtra = empleado.getHorasExtra();
            double salarioEmpleado = empleado.getSalario();
            boolean auxilioTransporte = empleado.isAuxilioTransporte();
            
            if (auxilioTransporte) {
                primas = (salarioEmpleado + valorHoraExtra + valorAuxilioTransporte)*0.0833;
                cesantias = (salarioEmpleado + valorHoraExtra + valorAuxilioTransporte)*0.0833;
                interesCesantias = (cesantias*0.12);
                vacaciones = (salarioEmpleado*0.0416);
            }else{
                primas = (salarioEmpleado + valorHoraExtra )*0.0833;
                cesantias = (salarioEmpleado + valorHoraExtra )*0.0833;
                interesCesantias = (cesantias*0.12);
                vacaciones = (salarioEmpleado*0.0416);
            }
            valorPrestaciones = (primas + cesantias + interesCesantias + vacaciones);
            prestaciones.add(valorPrestaciones);
        }
        return prestaciones;
    }
    
    //liquidar un empleado
    public double liquidarNominaEmp(Empleado empleado){
        double nomina ;
        if (empleado == null) {
            return 0;
        }
            double aportes = (empleado.getHorasExtra()+empleado.getSalario())*0.08;
            double neto = empleado.getHorasExtra()+empleado.getSalario();
            if (empleado.isAuxilioTransporte()) {
                nomina = (neto+106454-aportes);
            }else{
                nomina = (neto-aportes);
            }

        return nomina;
    }
        
      //prestaiones un empleado
    public double liquidarPrestacionesempd(Empleado empleado){
    double prestacion ;
    
    if(empleado == null){
        return 0;
    }
    

            double valorPrestaciones,  primas, cesantias, interesCesantias, vacaciones;
            int valorAuxilioTransporte = 106454;
            double valorHoraExtra = empleado.getHorasExtra();
            double salarioEmpleado = empleado.getSalario();
            boolean auxilioTransporte = empleado.isAuxilioTransporte();
            
            if (auxilioTransporte) {
                primas = (salarioEmpleado + valorHoraExtra + valorAuxilioTransporte)*0.0833;
                cesantias = (salarioEmpleado + valorHoraExtra + valorAuxilioTransporte)*0.0833;
                interesCesantias = (cesantias*0.12);
                vacaciones = (salarioEmpleado*0.0416);
            }else{
                primas = (salarioEmpleado + valorHoraExtra )*0.0833;
                cesantias = (salarioEmpleado + valorHoraExtra )*0.0833;
                interesCesantias = (cesantias*0.12);
                vacaciones = (salarioEmpleado*0.0416);
            }
            valorPrestaciones = (primas + cesantias + interesCesantias + vacaciones);
            prestacion=(valorPrestaciones);
        
        return prestacion;
    }
    
    
}

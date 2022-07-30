package model;
import clases.Empleado;
import java.sql.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;
public class ModelEmpleado extends dbData{
    
    public Empleado validarCedula(String identificacion){
        Empleado empleado = null;
        try(Connection connection = DriverManager.getConnection(getUrl(),getUser(),getPassword())){
            String query = "SELECT * FROM EMPLEADOS WHERE cedula = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, identificacion);
            ResultSet resultado  = stmt.executeQuery();
           
            while(resultado.next()){
            String idEmpleado = resultado.getString(1);
            String nombre = resultado.getString(2);
            String apellido = resultado.getString(3);
            float horasExtras = resultado.getFloat(4);
            int auxilioTransporte = resultado.getInt(5);
            double salario = resultado.getDouble(6);
            String cedula = resultado.getString(7);
             
                
            switch (auxilioTransporte) {
                    case 1 -> empleado = new Empleado(idEmpleado, nombre, apellido, horasExtras, true, salario, cedula);
                    case 0 -> empleado = new Empleado(idEmpleado,nombre, apellido, horasExtras, false, salario, cedula);
                    default -> throw new AssertionError();
            }  
            mostrarDatos(empleado); 
            } 
            stmt.close();
            resultado.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage()+ "error en la consulta: ");
            }
        return empleado;
    }
    
    public Empleado consultaEmpleadoId(String id){
        Empleado empleado = null;

        try(Connection connection = DriverManager.getConnection(getUrl(),getUser(),getPassword())){
            String query = "SELECT * FROM EMPLEADOS WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet resultado  = stmt.executeQuery();
           
            while(resultado.next()){
            String idEmpleado = resultado.getString(1);
            String nombre = resultado.getString(2);
            String apellido = resultado.getString(3);
            float horasExtras = resultado.getFloat(4);
            int auxilioTransporte = resultado.getInt(5);
            double salario = resultado.getDouble(6);
            String cedula = resultado.getString(7);
                
            switch (auxilioTransporte) {
                    case 1 -> empleado = new Empleado(idEmpleado, nombre, apellido, horasExtras, true, salario, cedula);
                    case 0 -> empleado = new Empleado(idEmpleado,nombre, apellido, horasExtras, false, salario, cedula);
                    default -> throw new AssertionError();
            }  
            mostrarDatos(empleado); 
            }
            stmt.close();
            resultado.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage()+ "error en la consulta: ");
            }
            
        return empleado;
    } 
     public void mostrarDatos(Empleado empleado){
        System.out.println("ID empleado: " + empleado.getId() + 
                           "\nNombre empleado: "+ empleado.getNombre() +
                           "\nApellido empleado: "+ empleado.getApellido() +
                           "\nHoras Extras: "  + empleado.getHorasExtra() +
                           "\nSalario: " + empleado.getSalario() +
                           "\nAuxilio transporte " + empleado.isAuxilioTransporte());
    }
     
    public boolean insertarEmpleado(String nombre, String apellido, float horaExtra, boolean auxilioTransporte, double salario, String cedula){
        try(Connection connection = DriverManager.getConnection(getUrl(),getUser(),getPassword())) {
            String query = "INSERT INTO EMPLEADOS (nombre, apellido, valor_hora_Extra, auxilio_transporte, salario_empleado, cedula)"
                        + "values (?,?,?,?,?,?) "; 
            PreparedStatement stmt = connection.prepareStatement(query);
            int auxTranporte;
            if (auxilioTransporte) {
                auxTranporte =1;
            }else{
                auxTranporte = 0;
            }
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setFloat(3, horaExtra);
            stmt.setInt(4, auxTranporte);
            stmt.setDouble(5, salario);
            stmt.setString(6, cedula);
            stmt.executeUpdate();
            stmt.close();
            return true;
            
        } catch (Exception e) {
            System.out.println("Error en la query: " + e.getMessage());
            return false;
        }
        
        
    
}
    
    
    public boolean editarEmpleado(int id, String nombre, String apellido, float horaExtra, boolean auxilioTransporte, double salario, String cedula){
        try(Connection connection = DriverManager.getConnection(getUrl(),getUser(),getPassword())) {
            String query = "UPDATE EMPLEADOS SET nombre=?, apellido=?, valor_hora_Extra=?, auxilio_transporte=?, salario_empleado=?, cedula=? WHERE id=?"; 
            PreparedStatement stmt = connection.prepareStatement(query);
            int auxTranporte;
            if (auxilioTransporte) {
                auxTranporte =1;
            }else{
                auxTranporte = 0;
            }
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setFloat(3, horaExtra);
            stmt.setInt(4, auxTranporte);
            stmt.setDouble(5, salario);
            stmt.setString(6, cedula);
            stmt.setInt(7, id);
            stmt.executeUpdate();
            stmt.close();
            return true;
            
        } catch (Exception e) {
            System.out.println("Error en la query: " + e.getMessage());
            return false;
        }
    }
    
    public boolean EliminarEmpleado(String id){
        Empleado empleado = consultaEmpleadoId(id);
        
        if (empleado != null) {
            try(Connection connection = DriverManager.getConnection(getUrl(),getUser(),getPassword())) {
            String query = "DELETE FROM EMPLEADOS WHERE id=?"; 
            PreparedStatement stmt = connection.prepareStatement(query);
            int idEmpleado = Integer.valueOf(id);
            stmt.setInt(1, idEmpleado);
            stmt.executeUpdate();
            stmt.close();
            return true;
            }catch(Exception e){
                System.out.println("error en la conexion" + e.getMessage());
            }
        }else{
            return false;
    }return false;
  
}
    public LinkedList<Empleado> listaEmpleados(){
        LinkedList<Empleado> empleadoLista = new LinkedList<>();
        Empleado empleado = null;
                try(Connection connection = DriverManager.getConnection(getUrl(),getUser(),getPassword())){
            String query = "SELECT id, nombre, apellido,valor_hora_Extra, auxilio_transporte, salario_empleado, cedula  FROM EMPLEADOS";
            Statement stmt = connection.createStatement();
            ResultSet resultado  = stmt.executeQuery(query);
           
            while(resultado.next()){
            String idEmpleado = resultado.getString(1);
            String nombre = resultado.getString(2);
            String apellido = resultado.getString(3);
            float horasExtras = resultado.getFloat(4);
            int auxilioTransporte = resultado.getInt(5);
            double salario = resultado.getDouble(6);
            String cedula = resultado.getString(7);
             
                
            switch (auxilioTransporte) {
                    case 1 -> empleado = new Empleado(idEmpleado, nombre, apellido, horasExtras, true, salario, cedula);
                    case 0 -> empleado = new Empleado(idEmpleado,nombre, apellido, horasExtras, false, salario, cedula);
                    default -> throw new AssertionError();
            }  
            mostrarDatos(empleado);
            empleadoLista.add(empleado);  
            }
            stmt.close();
            resultado.close();
            return empleadoLista;
            } catch (SQLException e) {
                System.out.println(e.getMessage()+ "error en la consulta: ");
            }
            return empleadoLista;
    }
}


        
    
    


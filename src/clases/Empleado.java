package clases;

public class Empleado {
    private String id;
    private String nombre;
    private String apellido;
    private  float horasExtra;
    private  double salario;
    private  boolean auxilioTransporte;
    private String cedula;
   
    // contructor
    public Empleado(String id, String nombre, String apellido, float horasExtra, boolean auxilioTransporte, double salario, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.horasExtra = horasExtra;
        this.auxilioTransporte = auxilioTransporte;
        this.salario = salario;
        this.cedula = cedula;
       
    }
    //getters and setters
    public float getHorasExtra() {
        return horasExtra;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(boolean auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
    
    
    
    
}

package objetos;


public class Profesor {
    
    private int idProfesor;
    private String nombre;
    private String apellido;
    private int numeroOrden;
    private int idEspecialidad;
    private int horasContratadas;

    public Profesor() {
    }
    
    public Profesor(String nombre, String apellido, int numeroOrden, int idEspecialidad, int horasContratadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroOrden = numeroOrden;
        this.idEspecialidad = idEspecialidad;
        this.horasContratadas = horasContratadas;
    }

    public Profesor(int idProfesor, String nombre, String apellido, int numeroOrden, int idEspecialidad, int horasContratadas) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroOrden = numeroOrden;
        this.idEspecialidad = idEspecialidad;
        this.horasContratadas = horasContratadas;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getHorasContratadas() {
        return horasContratadas;
    }

    public void setHorasContratadas(int horasContratadas) {
        this.horasContratadas = horasContratadas;
    }

    @Override
    public String toString() {
        return "Profesor{" + "idProfesor=" + idProfesor + ", nombre=" + nombre + ", apellido=" + apellido + ", numeroOrden=" + numeroOrden + ", idEspecialidad=" + idEspecialidad + ", horasContratadas=" + horasContratadas + '}';
    }
    
    public String[] toArrayStrings() {
        return new String[] {String.valueOf(this.idProfesor), this.nombre, this.apellido, String.valueOf(this.numeroOrden), String.valueOf(this.idEspecialidad), String.valueOf(this.horasContratadas)};
    }
    
}
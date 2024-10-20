package objetos;


public class Modulo {
    
    private String codigo;
    private String descripcion;
    private int horasReales;
    private int horasPonderadas;
    private int idEspecialidad;

    public Modulo() {
    }

    public Modulo(String codigo, String descripcion, int horasReales, int horasPonderadas, int idEspecialidad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.horasReales = horasReales;
        this.horasPonderadas = horasPonderadas;
        this.idEspecialidad = idEspecialidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHorasReales() {
        return horasReales;
    }

    public void setHorasReales(int horasReales) {
        this.horasReales = horasReales;
    }

    public int getHorasPonderadas() {
        return horasPonderadas;
    }

    public void setHorasPonderadas(int horasPonderadas) {
        this.horasPonderadas = horasPonderadas;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @Override
    public String toString() {
        return "Modulo{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", horasReales=" + horasReales + ", horasPonderadas=" + horasPonderadas + ", idEspecialidad=" + idEspecialidad + '}';
    }
    
    public String[] toArrayStrings() {
        return new String[] {String.valueOf(this.codigo), this.descripcion, String.valueOf(this.horasReales), String.valueOf(this.horasPonderadas), String.valueOf(this.idEspecialidad)};
    }
    
}
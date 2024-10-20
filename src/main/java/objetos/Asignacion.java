package objetos;


public class Asignacion {
    
    private int idProfesorModulo;
    private int idProfesor;
    private String codigoModulo;

    public Asignacion() {
    }

    public Asignacion(int idProfesorModulo, int idProfesor, String codigoModulo) {
        this.idProfesorModulo = idProfesorModulo;
        this.idProfesor = idProfesor;
        this.codigoModulo = codigoModulo;
    }

    public int getIdProfesorModulo() {
        return idProfesorModulo;
    }

    public void setIdProfesorModulo(int idProfesorModulo) {
        this.idProfesorModulo = idProfesorModulo;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getCodigoModulo() {
        return codigoModulo;
    }

    public void setCodigoModulo(String codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    @Override
    public String toString() {
        return "Asignacion{" + "idProfesorModulo=" + idProfesorModulo + ", idProfesor=" + idProfesor + ", codigoModulo=" + codigoModulo + '}';
    }
    
    public String[] toArrayStrings() {
        return new String[] {String.valueOf(this.idProfesorModulo), String.valueOf(this.idProfesor), this.codigoModulo};
    }
    
}
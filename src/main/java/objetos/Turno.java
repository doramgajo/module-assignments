package objetos;


public class Turno {
    
    private int idTurno;
    private String descripcion;

    public Turno() {
    }
    
    public Turno(String descripcion) {
        this.descripcion = descripcion;
    }

    public Turno(int idTurno, String descripcion) {
        this.idTurno = idTurno;
        this.descripcion = descripcion;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Turno{" + "idTurno=" + idTurno + ", descripcion=" + descripcion + '}';
    }
    
    public String[] toArrayStrings() {
        return new String[] {String.valueOf(this.idTurno), this.descripcion};
    }
    
}
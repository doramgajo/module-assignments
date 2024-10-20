package objetos;


public class Ciclo {
    
    private int idCiclo;
    private String nombre;
    private int idFamiliaProfesional;
    private String tipo;

    public Ciclo() {
    }
    
    public Ciclo(String nombre, int idFamiliaProfesional, String tipo) {
        this.nombre = nombre;
        this.idFamiliaProfesional = idFamiliaProfesional;
        this.tipo = tipo;
    }

    public Ciclo(int idCiclo, String nombre, int idFamiliaProfesional, String tipo) {
        this.idCiclo = idCiclo;
        this.nombre = nombre;
        this.idFamiliaProfesional = idFamiliaProfesional;
        this.tipo = tipo;
    }

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdFamiliaProfesional() {
        return idFamiliaProfesional;
    }

    public void setIdFamiliaProfesional(int idFamiliaProfesional) {
        this.idFamiliaProfesional = idFamiliaProfesional;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Ciclo{" + "idCiclo=" + idCiclo + ", nombre=" + nombre + ", idFamiliaProfesional=" + idFamiliaProfesional + ", tipo=" + tipo + '}';
    }
    
    public String[] toArrayStrings() {
        return new String[] {String.valueOf(this.idCiclo), this.nombre, String.valueOf(this.idFamiliaProfesional), this.tipo};
    }
    
}
package objetos;


public class FamiliaProfesional {
    
    private int idFamiliaProfesional;
    private String descripcion;

    public FamiliaProfesional() {
    }
    
    public FamiliaProfesional(String descripcion) {
        this.descripcion = descripcion;
    }

    public FamiliaProfesional(int idFamiliaProfesional, String descripcion) {
        this.idFamiliaProfesional = idFamiliaProfesional;
        this.descripcion = descripcion;
    }

    public int getIdFamiliaProfesional() {
        return idFamiliaProfesional;
    }

    public void setIdFamiliaProfesional(int idFamiliaProfesional) {
        this.idFamiliaProfesional = idFamiliaProfesional;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "FamiliaProfesional{" + "idFamiliaProfesional=" + idFamiliaProfesional + ", descripcion=" + descripcion + '}';
    }
    
    public String[] toArrayStrings() {
        return new String[] {String.valueOf(this.idFamiliaProfesional), this.descripcion};
    }
    
}
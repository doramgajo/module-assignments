package objetos;


public class ModuloCurso {
    
    private int idModuloCurso;
    private String codigoModulo;
    private String codigoCurso;

    public ModuloCurso() {
    }
    
    public ModuloCurso(String codigoModulo, String codigoCurso) {
        this.codigoModulo = codigoModulo;
        this.codigoCurso = codigoCurso;
    }

    public ModuloCurso(int idModuloCurso, String codigoModulo, String codigoCurso) {
        this.idModuloCurso = idModuloCurso;
        this.codigoModulo = codigoModulo;
        this.codigoCurso = codigoCurso;
    }

    public int getIdModuloCurso() {
        return idModuloCurso;
    }

    public void setIdModuloCurso(int idModuloCurso) {
        this.idModuloCurso = idModuloCurso;
    }

    public String getCodigoModulo() {
        return codigoModulo;
    }

    public void setCodigoModulo(String codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @Override
    public String toString() {
        return "ModuloCurso{" + "idModuloCurso=" + idModuloCurso + ", codigoModulo=" + codigoModulo + ", codigoCurso=" + codigoCurso + '}';
    }
    
    public String[] toArrayStrings() {
        return new String[] {String.valueOf(this.idModuloCurso), this.codigoModulo, this.codigoCurso};
    }
    
}
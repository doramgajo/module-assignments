package objetos;


public class EleccionModulo {

    private int idmodulo_curso;
    private String codigomodulo;
    private String codigoCurso;
    private String descripcionModulo;
    private int horasreales;
    private int horasponderadas;
    private int turno;
    private String descripcionCiclo;
    private String tipoGrado;
    private int nivel;

    public EleccionModulo() {
    }

    public EleccionModulo(int idmodulo_curso, String codigomodulo, String codigoCurso,
            String descripcionModulo, int horasreales, int horasponderadas,
            int turno, String descripcionCiclo, String tipoGrado, int nivel) {
        this.idmodulo_curso = idmodulo_curso;
        this.codigomodulo = codigomodulo;
        this.codigoCurso = codigoCurso;
        this.descripcionModulo = descripcionModulo;
        this.horasreales = horasreales;
        this.horasponderadas = horasponderadas;
        this.turno = turno;
        this.descripcionCiclo = descripcionCiclo;
        this.tipoGrado = tipoGrado;
        this.nivel = nivel;
    }

    public int getIdmodulo_curso() {
        return idmodulo_curso;
    }

    public void setIdmodulo_curso(int idmodulo_curso) {
        this.idmodulo_curso = idmodulo_curso;
    }

    public String getCodigomodulo() {
        return codigomodulo;
    }

    public void setCodigomodulo(String codigomodulo) {
        this.codigomodulo = codigomodulo;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getDescripcionModulo() {
        return descripcionModulo;
    }

    public void setDescripcionModulo(String descripcionModulo) {
        this.descripcionModulo = descripcionModulo;
    }

    public int getHorasreales() {
        return horasreales;
    }

    public void setHorasreales(int horasreales) {
        this.horasreales = horasreales;
    }

    public int getHorasponderadas() {
        return horasponderadas;
    }

    public void setHorasponderadas(int horasponderadas) {
        this.horasponderadas = horasponderadas;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public String getDescripcionCiclo() {
        return descripcionCiclo;
    }

    public void setDescripcionCiclo(String descripcionCiclo) {
        this.descripcionCiclo = descripcionCiclo;
    }

    public String getTipoGrado() {
        return tipoGrado;
    }

    public void setTipoGrado(String tipoGrado) {
        this.tipoGrado = tipoGrado;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getStringTurno() {
        switch (turno) {
            case 1 -> {
                return "Mañana";
            }
            case 2 -> {
                return "Tarde";
            }
            case 3 -> {
                return "Noche";
            }
            default -> {
                return "ERROR";
            }
        }
    }

    @Override
    public String toString() {
        return "EleccionModulo{" + "idmodulo_curso=" + idmodulo_curso + ", codigomodulo=" + codigomodulo + ", codigoCurso=" + codigoCurso + ", descripcionModulo=" + descripcionModulo + ", horasreales=" + horasreales + ", horasponderadas=" + horasponderadas + ", turno=" + turno + ", descripcionCiclo=" + descripcionCiclo + ", tipoGrado=" + tipoGrado + ", nivel=" + nivel + '}';
    }

    public String[] toArrayStrings() {
        return new String[]{Integer.toString(idmodulo_curso), codigomodulo, descripcionModulo, codigoCurso, descripcionCiclo, tipoGrado, Integer.toString(nivel), Integer.toString(horasreales), Integer.toString(horasponderadas)};
    }

    public String[] toArrayStringsConTurno() {
        String turnoo = "";
        switch (turno) {
            case 1 -> turnoo = "Mañana";
            case 2 -> turnoo = "Tarde";
            case 3 -> turnoo = "Noche";
        }
        
    return new String[]

    {
        Integer.toString(idmodulo_curso), codigomodulo, descripcionModulo, codigoCurso, descripcionCiclo, tipoGrado
        , Integer.toString(nivel)
        , Integer.toString(horasreales)
        , Integer.toString(horasponderadas), turnoo
    }
;
}
    
}

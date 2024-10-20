package objetos;


public class Curso {
    
    private String codigo;
    private int idTurno;
    private int idCiclo;
    private int nivel;

    public Curso() {
    }

    public Curso(String codigo, int idTurno, int idCiclo, int nivel) {
        this.codigo = codigo;
        this.idTurno = idTurno;
        this.idCiclo = idCiclo;
        this.nivel = nivel;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", idTurno=" + idTurno + ", idCiclo=" + idCiclo + ", nivel=" + nivel + '}';
    }
    
    public String[] toArrayStrings() {
        return new String[] {this.codigo, String.valueOf(this.idTurno), String.valueOf(this.idCiclo), String.valueOf(this.nivel)};
    }
    
}
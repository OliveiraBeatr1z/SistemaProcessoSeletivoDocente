package model;

public class Curso {
    private String codigoCurso;
    private String nomeCurso;
    private String areaConhecimentoCurso;

    // Getters e Setters
    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getAreaConhecimentoCurso() {
        return areaConhecimentoCurso;
    }

    public void setAreaConhecimentoCurso(String areaConhecimentoCurso) {
        this.areaConhecimentoCurso = areaConhecimentoCurso;
    }

    // toString para salvar no CSV
    @Override
    public String toString() {
        return codigoCurso + ";" + nomeCurso + ";" + areaConhecimentoCurso;
    }
}

package model;

public class Curso {

	private String codigoCurso;
	private String nomeCurso;
	private String areaConhecimentoCurso;
	
	public Curso() {
		
	}

	public Curso(String codigoCurso, String nomeCurso, String areaConhecimentoCurso) {
		super();
		this.codigoCurso = codigoCurso;
		this.nomeCurso = nomeCurso;
		this.areaConhecimentoCurso = areaConhecimentoCurso;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String string) {
		this.codigoCurso = string;
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

	@Override
	public String toString() {
		return codigoCurso + ";" + nomeCurso + ";"
				+ areaConhecimentoCurso;
	}
	
	
}

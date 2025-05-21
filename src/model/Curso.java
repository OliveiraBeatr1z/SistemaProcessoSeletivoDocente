package model;

public class Curso {
	private long codCurso;
	private String nomeCurso;
	private String areaConhecimentoCurso;
	
	@Override
	public String toString() {
		return "Curso [codCurso=" + codCurso + ", nomeCurso=" + nomeCurso + ", areaConhecimentoCurso="
				+ areaConhecimentoCurso + "]";
	}

	public long getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(long codCurso) {
		this.codCurso = codCurso;
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
	
	
}

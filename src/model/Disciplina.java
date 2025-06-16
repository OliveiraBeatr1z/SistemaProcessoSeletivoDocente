package model;


public class Disciplina {

	private String codigoDisciplina;
	private String nomeDisciplina;
	private String diaSemana;
	private String horarioAula;
	private String horasDiarias;
	private Curso codigoCurso;
	
	

	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}



	public void setCodigoDisciplina(String codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}



	public String getNomeDisciplina() {
		return nomeDisciplina;
	}



	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}



	public String getDiaSemana() {
		return diaSemana;
	}



	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}



	public String getHorarioAula() {
		return horarioAula;
	}



	public void setHorarioAula(String horarioAula) {
		this.horarioAula = horarioAula;
	}



	public String getHorasDiarias() {
		return horasDiarias;
	}



	public void setHorasDiarias(String horasDiarias) {
		this.horasDiarias = horasDiarias;
	}



	public Curso getCodigoCurso() {
		return codigoCurso;
	}



	public void setCodigoCurso(Curso codigoCurso) {
		this.codigoCurso = codigoCurso;
	}



	@Override
	public String toString() {
		return codigoDisciplina + ";" + nomeDisciplina
				+ ";" + diaSemana + ";" + horarioAula + ";" + horasDiarias
				+ ";" + codigoCurso;
	}
	
	
}

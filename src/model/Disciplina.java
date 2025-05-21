package model;

import java.time.LocalTime;

public class Disciplina {
	private long codDisciplina;
	private String nomeDisciplina;
	private String diaSemana;
	private LocalTime horarioInicio;
	private int horasDiarias;
	
	@Override
	public String toString() {
		return "Disciplina [codDisciplina=" + codDisciplina + ", nomeDisciplina=" + nomeDisciplina + ", diaSemana="
				+ diaSemana + ", horarioInicio=" + horarioInicio + ", horasDiarias=" + horasDiarias + "]";
	}

	public long getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(long codDisciplina) {
		this.codDisciplina = codDisciplina;
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

	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public int getHorasDiarias() {
		return horasDiarias;
	}

	public void setHorasDiarias(int horasDiarias) {
		this.horasDiarias = horasDiarias;
	}
	
	
}

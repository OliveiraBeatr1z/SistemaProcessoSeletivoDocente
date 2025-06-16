package model;

public class Disciplina {
    private String codigoDisciplina;
    private String nomeDisciplina;
    private String diaDisciplina;
    private int horaAulaDisciplina;
    private int duracaoAula;
    
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
	public String getDiaDisciplina() {
		return diaDisciplina;
	}
	public void setDiaDisciplina(String diaDisciplina) {
		this.diaDisciplina = diaDisciplina;
	}
	public int getHoraAulaDisciplina() {
		return horaAulaDisciplina;
	}
	public void setHoraAulaDisciplina(int horaAulaDisciplina) {
		this.horaAulaDisciplina = horaAulaDisciplina;
	}
	public int getDuracaoAula() {
		return duracaoAula;
	}
	public void setDuracaoAula(int qtdeHora) {
		this.duracaoAula = qtdeHora;
	}
    
    
	@Override
	public String toString() {
	    return codigoDisciplina + ";" + nomeDisciplina + ";" + diaDisciplina + ";" + horaAulaDisciplina + ";" + duracaoAula;
	}

    
}

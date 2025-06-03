package model;

public class Inscricao {
	private String codProcesso;
    private String cpfProfessor;
    private String codigoDisciplina;
    
	@Override
	public String toString() {
		return "Inscricao [codProcesso=" + codProcesso + ", cpfProfessor=" + cpfProfessor + ", codigoDisciplina="
				+ codigoDisciplina + "]";
		
	}

	public String getCodProcesso() {
		return codProcesso;
	}

	public void setCodProcesso(String codProcesso) {
		this.codProcesso = codProcesso;
	}

	public String getCpfProfessor() {
		return cpfProfessor;
	}

	public void setCpfProfessor(String cpfProfessor) {
		this.cpfProfessor = cpfProfessor;
	}

	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(String codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}
	
	
	
    
}

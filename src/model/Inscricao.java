package model;

public class Inscricao {
	private long codProcesso;
    private String cpfProfessor;
    private long codigoDisciplina;
    
	@Override
	public String toString() {
		return "Inscricao [codProcesso=" + codProcesso + ", cpfProfessor=" + cpfProfessor + ", codigoDisciplina="
				+ codigoDisciplina + "]";
		
	}
	public long getCodProcesso() {
		return codProcesso;
	}
	public void setCodProcesso(long codProcesso) {
		this.codProcesso = codProcesso;
	}
	public String getCpfProfessor() {
		return cpfProfessor;
	}
	public void setCpfProfessor(String cpfProfessor) {
		this.cpfProfessor = cpfProfessor;
	}
	public long getCodigoDisciplina() {
		return codigoDisciplina;
	}
	public void setCodigoDisciplina(long codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}
	
    
}

package model;

public class Professor {
	
	private String cpf;
	private String areaConhecimento;
	private int pontuacao;
	
	@Override
	public String toString() {
		return "Professor [cpf=" + cpf + ", areaConhecimento=" + areaConhecimento + ", pontuacao=" + pontuacao + "]";
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getAreaConhecimento() {
		return areaConhecimento;
	}
	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	

}

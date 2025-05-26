package model;

public class Professor {
	
	private String cpf;
	private String areaConhecimento;
	private double pontuacao;
	
	public Professor(String cpf, String areaConhecimento, double pontuacao) {
		super();
		this.cpf = cpf;
		this.areaConhecimento = areaConhecimento;
		this.pontuacao = pontuacao;
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
	public double getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	

}

package service;

import java.io.IOException;

import model.Professor;
import repository.ProfessorRepository;

public class ProfessorService {
	private ProfessorRepository repository;
	
	public ProfessorService() {
		this.repository = new ProfessorRepository();
	}
	
	public void cadastrarProfessor(Professor professor) throws IOException{
		repository.salvar(professor);
	}
	
	public Professor buscarPorCpf(String cpf) throws IOException{
		return repository.buscaPorCpf(cpf);
	}
}

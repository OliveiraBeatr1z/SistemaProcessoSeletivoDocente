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
		repository.salvarProfessor(professor);
	}
	
	public Professor buscarPorCpf(String string) throws IOException{
		return repository.buscaPorCpf(string);
	}
	
	public void atualizarProfessor(Professor professor) throws IOException {
	    repository.salvarProfessor(professor); 
	}

	public void removerProfessor(String cpf) throws Exception {
	    repository.removerProfessor(cpf);
	}

}

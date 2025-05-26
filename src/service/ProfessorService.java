package service;

import model.Professor;
import repository.ProfessorRepository;

public class ProfessorService {
	    private ProfessorRepository repository = new ProfessorRepository();

	    public void cadastrarProfessor(Professor professor) {
	        if (validarProfessor(professor)) {
	            repository.salvarProfessor(professor);
	        }
	    }

	    private boolean validarProfessor(Professor professor) {
	        return professor.getCpf() != null && professor.getPontuacao() >= 0;
	    }

		
	

}

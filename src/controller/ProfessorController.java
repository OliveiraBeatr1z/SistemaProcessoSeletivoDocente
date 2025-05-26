package controller;

import model.Professor;
import service.ProfessorService;

public class ProfessorController {
	
	    private ProfessorService service = new ProfessorService();

	    public void cadastrarProfessor(String cpf, String area, double pontuacao) {
	        Professor p = new Professor(cpf, area, pontuacao);
	        service.cadastrarProfessor(p);
	    }



}

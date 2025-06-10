package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Professor;
import service.ProfessorService;

public class ProfessorController implements ActionListener {
	
	private JTextField tfCpf;
	private JTextField tfNomeProfessor;
	private JTextField tfAreaConhecimentoProfessor;
	private JTextArea taProfessoresLista;
	
	public ProfessorController(JTextField tfCpf, JTextField tfNome, JTextField tfAreaConhecimento, JTextArea taProfessoresLista) {
		super();
		this.tfCpf = tfCpf;
		this.tfNomeProfessor = tfNome;
		this.tfAreaConhecimentoProfessor = tfAreaConhecimento;
		this.taProfessoresLista = taProfessoresLista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		
		 try {
	            if (cmd.equals("Cadastrar")) {
	                cadastrar();
	            } else if (cmd.equals("Buscar")) {
	                buscar();
	            }
	        } catch (IOException ex) {
	            taProfessoresLista.setText("Erro: " + ex.getMessage());
	        }
	}

	private void cadastrar() throws IOException {
		Professor professor = new Professor();
		professor.setCpf(tfCpf.getText());
		professor.setNomeProfessor(tfNomeProfessor.getText());
		
		ProfessorService professorService = new ProfessorService();
		professorService.cadastrarProfessor(professor);
		
		tfCpf.setText("");
		tfNomeProfessor.setText("");
		tfAreaConhecimentoProfessor.setText("");
		taProfessoresLista.setText("");
	}


	private void buscar() throws IOException {
		String cpf = tfCpf.getText();
		Professor professor = new Professor();
		ProfessorService service = new ProfessorService(); 
		professor = service.buscarPorCpf(cpf);  

		if(professor.getNomeProfessor() != null) {
			taProfessoresLista.setText("CPF: " + professor.getCpf() + " - Nome: " + professor.getNomeProfessor() + " - Area de conhecimento: " + professor.getAreaConhecimento());
		} else {
			taProfessoresLista.setText("Professor não encontrado.");
		}
		
		tfCpf.setText("");
		tfNomeProfessor.setText("");
		tfAreaConhecimentoProfessor.setText("");
	}
}

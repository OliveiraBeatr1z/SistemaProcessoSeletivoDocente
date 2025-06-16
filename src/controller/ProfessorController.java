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
	            } else if (cmd.equals("Atualizar")) {
	            	atualizar();
	            } else if (cmd.equals("Deletar")) {
	            	try {
						deletar();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        } catch (IOException ex) {
	            taProfessoresLista.setText("Erro: " + ex.getMessage());
	        }
		 
		 
	}

	private void cadastrar() throws IOException {
		Professor professor = new Professor();
		professor.setCpf(tfCpf.getText());
		professor.setNome(tfNomeProfessor.getText());
		professor.setAreaConhecimento(tfAreaConhecimentoProfessor.getText());
		
		ProfessorService professorService = new ProfessorService();
		professorService.cadastrarProfessor(professor);
		
		tfCpf.setText("");
		tfNomeProfessor.setText("");
		tfAreaConhecimentoProfessor.setText("");
		taProfessoresLista.setText("");
	}


	private void buscar() throws IOException {
		Professor professor = new Professor();
		ProfessorService service = new ProfessorService(); 
		
		professor = service.buscarPorCpf(tfCpf.getText());  

		if(professor != null) {
			taProfessoresLista.setText("CPF: " + professor.getCpf() + " - Nome: " + professor.getNome() + " - Area de conhecimento: " + professor.getAreaConhecimento());
		} else {
			taProfessoresLista.setText("Professor não encontrado.");
			tfCpf.setText("");
			tfNomeProfessor.setText("");
			tfAreaConhecimentoProfessor.setText("");
		}
		
	}
	
	 private void atualizar() throws IOException {
	        Professor professor = new Professor();
	        professor.setCpf(tfCpf.getText());
	        professor.setNome(tfNomeProfessor.getText());
	        professor.setAreaConhecimento(tfAreaConhecimentoProfessor.getText());

	        ProfessorService service = new ProfessorService();
	        service.atualizarProfessor(professor); // salva com o mesmo CPF sobrescreve a linha

	        taProfessoresLista.setText("Professor atualizado com sucesso.");
	        tfCpf.setText("");
			tfNomeProfessor.setText("");
			tfAreaConhecimentoProfessor.setText("");
	    }

	    private void deletar() throws IOException, Exception {
	        String cpf = tfCpf.getText();
	        ProfessorService service = new ProfessorService();
	        service.removerProfessor(cpf);

	        taProfessoresLista.setText("Professor deletado com sucesso.");
	        tfCpf.setText("");
			tfNomeProfessor.setText("");
			tfAreaConhecimentoProfessor.setText("");
	    }
	
}

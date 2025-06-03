package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Inscricao;
import model.Professor;

public class InscricaoController implements ActionListener  {

	
	private JTextField tfCodProcesso;
	private JTextField tfCpfProfessor;
	private JTextField tfcodigoDisciplina;
	private JTextArea taInscricaoLista;
	
	
	
	public InscricaoController(JTextField tfCodProcesso, JTextField tfCpfProfessor, JTextField tfcodigoDisciplina,
			JTextArea taInscricaoLista) {
		super();
		this.tfCodProcesso = tfCodProcesso;
		this.tfCpfProfessor = tfCpfProfessor;
		this.tfcodigoDisciplina = tfcodigoDisciplina;
		this.taInscricaoLista = taInscricaoLista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		if(cmd.equals("Cadastrar")) {
			cadastro();
		}
		if(cmd.equals("Buscar")) {
			buscar();
		}
		
	}

	private void cadastro() {
		Inscricao inscricao = new Inscricao();
		inscricao.setCodProcesso(tfCodProcesso.getText());
		inscricao.setCpfProfessor(tfCpfProfessor.getText());
		inscricao.setCodigoDisciplina(tfcodigoDisciplina.getText());
		
		System.out.println(inscricao);
		
	}

	private void buscar() {
		Inscricao inscricao = new Inscricao();
		inscricao.setCodProcesso(tfCodProcesso.getText());
	} 
	



}

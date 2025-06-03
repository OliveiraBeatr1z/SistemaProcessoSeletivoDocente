package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.Disciplina;

public class DisciplinaController implements ActionListener {
	private JTextField codDisciplina;
	private JTextField nomeDisciplina;

	
	public DisciplinaController(JTextField codDisciplina, JTextField nomeDisciplina, JTextField diaSemana,
		JTextField horasDiarias) {
		super();
		this.codDisciplina = codDisciplina;
		this.nomeDisciplina = nomeDisciplina;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); // pega o texto que foi colocado no tf . 
		
		if(cmd.equals("Buscar")) {
			buscar();
		}		
	}

	
	private void buscar() {
		Disciplina disciplina = new Disciplina();
		disciplina.setCodDisciplina(codDisciplina.getText());
		disciplina.setNomeDisciplina(nomeDisciplina.getText());
		
		System.out.println(disciplina);
		
	}
}

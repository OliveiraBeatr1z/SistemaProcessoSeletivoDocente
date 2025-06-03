package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Curso;

public class CursoController implements ActionListener {
	
	private JTextField tfCodCurso;
	private JTextField tfNomeCurso;
	private JTextField tfAreaConhecimentoCurso;
	private JTextArea taCursoLista;
	
	// quando clicar no botão, todos esses elementos serao passados para essa classe. 
	public CursoController(JTextField tfCodCurso, JTextField tfNomeCurso, JTextField tfAreaConhecimentoCurso,
			JTextArea taCursoLista) {
		super();
		this.tfCodCurso = tfCodCurso;
		this.tfNomeCurso = tfNomeCurso;
		this.tfAreaConhecimentoCurso = tfAreaConhecimentoCurso;
		this.taCursoLista = taCursoLista;
	}
	
	// essa classe ouve o click do botão e aciona esse método.
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); // pega o texto que foi colocado no tf . 
		if(cmd.equals("Cadastrar")) {
			cadastro();
		}
		if(cmd.equals("Buscar")) {
			buscar();
		}
		
	}

	private void buscar() {
		Curso curso = new Curso();
		curso.setCodCurso(tfCodCurso.getText());
		
		System.out.println(curso);
		
	}

	private void cadastro() {
		Curso curso = new Curso();
		curso.setCodCurso(tfCodCurso.getText());
		curso.setNomeCurso(tfNomeCurso.getText());
		curso.setAreaConhecimentoCurso(tfAreaConhecimentoCurso.getText());
		
		System.out.println(curso);
		
	}
	
	
	
}	

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.beatrizoliveiralistagenerica.Lista;
import model.Curso;
import service.CursoService;

public class CursoController implements ActionListener {
	
	private JTextField tfCodCurso;
	private JTextField tfNomeCurso;
	private JTextField tfAreaConhecimentoCurso;
	private JTextArea taCursoLista;
	

	public CursoController(JTextField tfCodCurso, JTextField tfNomeCurso, JTextField tfAreaConhecimentoCurso,
			JTextArea taCursoLista) {
		super();
		this.tfCodCurso = tfCodCurso;
		this.tfNomeCurso = tfNomeCurso;
		this.tfAreaConhecimentoCurso = tfAreaConhecimentoCurso;
		this.taCursoLista = taCursoLista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		if(cmd.equals("Cadastrar")) {
			try {
				cadastro();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(cmd.equals("Buscar")) {
			try {
				buscar();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		if(cmd.equals("Atualizar")) {
			try {
				atualizar();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		if(cmd.equals("Remover")) {
			try {
				remover();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}

	private void cadastro() throws IOException {
		Curso curso = new Curso();
		curso.setCodigoCurso(tfCodCurso.getText());
		curso.setNomeCurso(tfNomeCurso.getText());
		curso.setAreaConhecimentoCurso(tfAreaConhecimentoCurso.getText());
		
		System.out.println(curso);
		
		CursoService cursoService = new CursoService();
		cursoService.cadastrarCurso(curso);
		
		tfCodCurso.setText("");
		tfNomeCurso.setText("");
		tfAreaConhecimentoCurso.setText("");
		
	}
	
	private void buscar() throws Exception {
		Curso curso = new Curso();
		curso.setCodigoCurso(tfCodCurso.getText());
		curso.setNomeCurso(tfNomeCurso.getText());
		
		CursoService cursoService = new CursoService();
		Lista<Curso> cursos = cursoService.buscarCursos(curso);
		
		if(cursos != null && cursos.size() > 0) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < cursos.size(); i++) {
	            Curso c = cursos.get(i);
	            builder.append("Código curso: ").append(c.getCodigoCurso())
	              .append(" - Nome: ").append(c.getNomeCurso())
	              .append(" - Area de Conhecimento: ").append(c.getAreaConhecimentoCurso())
	              .append("\n");
	            System.out.println(cursos);
	        }
			taCursoLista.setText(builder.toString());
	    } else {
	        taCursoLista.setText("Nenhum curso encontrado.");
		}
		
		tfCodCurso.setText("");
		tfNomeCurso.setText("");
		tfAreaConhecimentoCurso.setText("");
	}
	
	private void atualizar() throws IOException {
	    Curso curso = new Curso();
	    curso.setCodigoCurso(tfCodCurso.getText());
	    curso.setNomeCurso(tfNomeCurso.getText());
	    curso.setAreaConhecimentoCurso(tfAreaConhecimentoCurso.getText());

	    CursoService cursoService = new CursoService();
	    cursoService.atualizarCurso(curso);

	    tfCodCurso.setText("");
	    tfNomeCurso.setText("");
	    tfAreaConhecimentoCurso.setText("");
	    taCursoLista.setText("Curso atualizado com sucesso!");
	}

	private void remover() throws IOException {
	    String codigo = tfCodCurso.getText();
	    if (!codigo.isBlank()) {
	        CursoService cursoService = new CursoService();
	        cursoService.removerCurso(codigo);

	        tfCodCurso.setText("");
	        tfNomeCurso.setText("");
	        tfAreaConhecimentoCurso.setText("");
	        taCursoLista.setText("Curso removido com sucesso!");
	    } else {
	        taCursoLista.setText("Informe o código do curso para remover.");
	    }
	}

}	

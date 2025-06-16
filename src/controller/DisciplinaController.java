package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Disciplina;
import service.DisciplinaService;

public class DisciplinaController implements ActionListener {
    private JTextField tfCodDisciplina;
    private JTextField tfNomeDisciplina;
    private JTextField tfDiaSemanaDisciplina;
    private JTextField tfHoraAulaDisciplina;
    private JTextField tfDuracaoAula;
    private JTextArea taDisciplinasLista;

    

    public DisciplinaController(JTextField tfCodDisciplina, JTextField tfNomeDisciplina,
			JTextField tfDiaSemanaDisciplina, JTextField tfHoraAulaDisciplina, JTextField tfDuracaoAula, JTextArea taDisciplinasLista) {
		super();
		this.tfCodDisciplina = tfCodDisciplina;
		this.tfNomeDisciplina = tfNomeDisciplina;
		this.tfDiaSemanaDisciplina = tfDiaSemanaDisciplina;
		this.tfHoraAulaDisciplina = tfHoraAulaDisciplina;
		this.tfDuracaoAula = tfDuracaoAula;
		this.taDisciplinasLista = taDisciplinasLista;
	}

	@Override
    public void actionPerformed(ActionEvent e) {
		 String cmd = e.getActionCommand();

		    try {
		        if (cmd.equals("Cadastrar")) {
		            cadastrar();
		        } else if (cmd.equals("Buscar")) {
		            buscar();
		        }else if (cmd.equals("Atualizar")) {
		            atualizar();
		        } else if (cmd.equals("Deletar")) {
		            deletar();
		        }

		    } catch (IOException ex) {
		        taDisciplinasLista.setText("Erro: " + ex.getMessage());
		    }
		}

	private void cadastrar() throws IOException {
	    Disciplina disciplina = new Disciplina();
	    disciplina.setCodigoDisciplina(tfCodDisciplina.getText());
	    disciplina.setNomeDisciplina(tfNomeDisciplina.getText());
	    disciplina.setDiaDisciplina(tfDiaSemanaDisciplina.getText());
	    disciplina.setDuracaoAula(Integer.parseInt(tfDuracaoAula.getText()));

	    DisciplinaService service = new DisciplinaService();
	    service.cadastrarDisciplina(disciplina);

	    taDisciplinasLista.setText("Disciplina cadastrada com sucesso!");

	    tfCodDisciplina.setText("");
	    tfNomeDisciplina.setText("");
	    tfDiaSemanaDisciplina.setText("");
	    tfHoraAulaDisciplina.setText("");
	    tfDuracaoAula.setText("");
	}

	private void buscar() throws IOException {
	    DisciplinaService service = new DisciplinaService();
	    Disciplina disciplina = service.buscarPorCodigo(tfCodDisciplina.getText());

	    if (disciplina != null) {
	        taDisciplinasLista.setText("Código: " + disciplina.getCodigoDisciplina()
	            + "\nNome: " + disciplina.getNomeDisciplina()
	            + "\nDia da semana: " + disciplina.getDiaDisciplina()
	            + "\nHorário de Inicio:" + disciplina.getHoraAulaDisciplina()
	            + "\nCarga horária: " + disciplina.getDuracaoAula());
	    } else {
	        taDisciplinasLista.setText("Disciplina não encontrada.");
	    }
	}
	
	private void atualizar() throws IOException {
	    Disciplina disciplina = new Disciplina();
	    disciplina.setCodigoDisciplina(tfCodDisciplina.getText());
	    disciplina.setNomeDisciplina(tfNomeDisciplina.getText());
	    disciplina.setDiaDisciplina(tfDiaSemanaDisciplina.getText());
	    disciplina.setHoraAulaDisciplina(Integer.parseInt(tfHoraAulaDisciplina.getText()));
	    disciplina.setDuracaoAula(Integer.parseInt(tfHoraAulaDisciplina.getText()));

	    DisciplinaService service = new DisciplinaService();
	    service.atualizarDisciplina(disciplina);

	    taDisciplinasLista.setText("Disciplina atualizada com sucesso!");

	    tfCodDisciplina.setText("");
	    tfNomeDisciplina.setText("");
	    tfDiaSemanaDisciplina.setText("");
	    tfHoraAulaDisciplina.setText("");
	    tfDuracaoAula.setText("");
	}

	private void deletar() throws IOException {
	    String codigo = tfCodDisciplina.getText();

	    DisciplinaService service = new DisciplinaService();
	    service.removerDisciplina(codigo);

	    taDisciplinasLista.setText("Disciplina deletada com sucesso!");

	    tfCodDisciplina.setText("");
	    tfNomeDisciplina.setText("");
	    tfDiaSemanaDisciplina.setText("");
	    tfHoraAulaDisciplina.setText("");
	    tfDuracaoAula.setText("");
	}

   
}

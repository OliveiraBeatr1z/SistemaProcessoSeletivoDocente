package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.beatrizoliveiralistagenerica.Lista;
import model.Inscricao;
import service.InscricaoService;

public class InscricaoController implements ActionListener  {

	
	private JTextField tfCodProcesso;
	private JTextField tfCpfProfessor;
	private JTextField tfcodigoDisciplina;
	private JTextField tfPontuacao;
	private JTextArea taInscricaoLista;
	
	
	
	public InscricaoController(JTextField tfCodProcesso, JTextField tfCpfProfessor, JTextField tfcodigoDisciplina,
			JTextField tfPontuacao , JTextArea taInscricaoLista) {
		super();
		this.tfCodProcesso = tfCodProcesso;
		this.tfCpfProfessor = tfCpfProfessor;
		this.tfcodigoDisciplina = tfcodigoDisciplina;
		this.taInscricaoLista = taInscricaoLista;
		this.tfPontuacao = tfPontuacao;
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
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	private void cadastro() throws IOException {
		Inscricao inscricao = new Inscricao();
		inscricao.setCodProcesso(tfCodProcesso.getText());
		inscricao.setCpfProfessor(tfCpfProfessor.getText());
		inscricao.setCodigoDisciplina(tfcodigoDisciplina.getText());
		inscricao.setPontuacao(tfPontuacao.getText());
		
		System.out.println(inscricao);
		
		InscricaoService inscricaoService = new InscricaoService();
		inscricaoService.cadastraInscricao(inscricao);

		tfCodProcesso.setText("");
		tfCpfProfessor.setText("");
		tfcodigoDisciplina.setText("");
		taInscricaoLista.setText("");
		tfPontuacao.setText("");
	}
		
	private void buscar() throws IOException {
	    Inscricao inscricao = new Inscricao();
	    inscricao.setCodProcesso(tfCodProcesso.getText());
	    inscricao.setCpfProfessor(tfCpfProfessor.getText());

	    InscricaoService service = new InscricaoService(); 
	    try {
	        service.buscaInscricao(inscricao, taInscricaoLista);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    tfCodProcesso.setText("");
	    tfCpfProfessor.setText("");
	    tfcodigoDisciplina.setText("");
	    tfPontuacao.setText("");
	}
}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Inscricao;
import model.Professor;
import service.InscricaoService;
import service.ProfessorService;

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
		inscricao.setPontuacao(tfPontuacao.getText());
		
		System.out.println(inscricao);
		repository.cadastraInscricao(inscricao.toString());

		tfCodProcesso.setText("null");
		tfCpfProfessor.setText("null");
		tfcodigoDisciplina.setText("null");
		taInscricaoLista.setText("null");
		tfPontuacao.setText("null");
	}
		
	private void buscar() {
		Inscricao inscricao = new Inscricao();
		InscricaoService service = new InscricaoService(); 
		
		inscricao = service.buscaInscricao(inscricao);  

		if(inscricao != null) {
			taInscricaoLista.setText("CPF: " + inscricao.getCpf() + " - Nome: " + inscricao.getNome() + " - Area de conhecimento: " + inscricao.getAreaConhecimento());
		} else {
			taInscricaoLista.setText("Professor não encontrado.");
		}
		
		tfCodProcesso.setText("null");
		tfCpfProfessor.setText("null");
		tfcodigoDisciplina.setText("null");
		taInscricaoLista.setText("null");
		tfPontuacao.setText("null");

	} 
	



}

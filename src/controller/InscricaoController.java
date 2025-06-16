package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
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
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		}
		
		if (cmd.equals("Atualizar")) {
		    atualizar();
		}

		if (cmd.equals("Deletar")) {
		     try {
				deletar();
			 } catch (Exception e1) {
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
		
		InscricaoService inscricaoService = new InscricaoService();
		inscricaoService.cadastraInscricao(inscricao);

		tfCodProcesso.setText("");
		tfCpfProfessor.setText("");
		tfcodigoDisciplina.setText("");
		taInscricaoLista.setText("");
		tfPontuacao.setText("");
	}
		
	private void buscar() throws Exception {
	    Inscricao filtro = new Inscricao();
	    filtro.setCodProcesso(tfCodProcesso.getText().trim());
	    filtro.setCpfProfessor(tfCpfProfessor.getText().trim());

	    InscricaoService inscricaoService = new InscricaoService();
	    Lista<Inscricao> inscricoes = inscricaoService.buscarInscricoes(filtro);

	    if (inscricoes != null && inscricoes.size() > 0) {
	        StringBuilder builder = new StringBuilder();
	        for (int j = 0; j < inscricoes.size(); j++) {
	            Inscricao i = inscricoes.get(j);
	            builder.append("Processo: ").append(i.getCodProcesso())
	              .append(" - CPF: ").append(i.getCpfProfessor())
	              .append(" - Disciplina: ").append(i.getCodigoDisciplina())
	              .append(" - Pontuação: ").append(i.getPontuacao())
	              .append("\n");
	        }
	        taInscricaoLista.setText(builder.toString());
	    } else {
	        taInscricaoLista.setText("Nenhuma inscrição encontrada.");
	    }

	    tfCodProcesso.setText("");
	    tfCpfProfessor.setText("");
	    tfcodigoDisciplina.setText("");
	    tfPontuacao.setText("");
	}
	
	private void deletar() throws Exception {
	    String codProcesso = tfCodProcesso.getText();
	    String cpf = tfCpfProfessor.getText();

	    if (codProcesso.equals("") || cpf.equals("")) {
	        JOptionPane.showMessageDialog(null, "Informe o código do processo e o CPF para remover.", "Erro", JOptionPane.ERROR_MESSAGE);
	       
	    }

	    InscricaoService service = new InscricaoService();
	    service.removerInscricao(codProcesso, cpf); // remove do arquivo

	    // Criar o filtro para buscar novamente as inscrições restantes
	    Inscricao filtro = new Inscricao();
	    filtro.setCodProcesso(codProcesso); // usa o processo como filtro

	    Lista<Inscricao> atualizadas = service.buscarInscricoes(filtro); // usa o seu método atual

	    StringBuffer buffer = new StringBuffer();
	    for (int i = 0; i < atualizadas.size(); i++) {
	        Inscricao iTemp = atualizadas.get(i);
	        buffer.append("Processo: " + iTemp.getCodProcesso() +
	                      " - CPF: " + iTemp.getCpfProfessor() +
	                      " - Disciplina: " + iTemp.getCodigoDisciplina() +
	                      " - Pontuação: " + iTemp.getPontuacao() + "\n");
	    }

	    taInscricaoLista.setText(buffer.toString());

	    // limpa os campos
	    tfCodProcesso.setText("");
	    tfCpfProfessor.setText("");
	    tfcodigoDisciplina.setText("");
	    tfPontuacao.setText("");
	}
	
	private void atualizar() {
	    try {
	        String codProcesso = tfCodProcesso.getText().trim();
	        String cpf = tfCpfProfessor.getText().trim();
	        String novaDisciplina = tfcodigoDisciplina.getText().trim();
	        String novaPontuacao = tfPontuacao.getText().trim();

	        if (codProcesso.equals("") || cpf.equals("")) {
	            JOptionPane.showMessageDialog(null, "Informe o código do processo e o CPF do professor para atualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        InscricaoService service = new InscricaoService();
	        service.atualizarInscricao(codProcesso, cpf, novaDisciplina, novaPontuacao);

	        JOptionPane.showMessageDialog(null, "Inscrição atualizada com sucesso!");

	        tfCodProcesso.setText("");
	        tfCpfProfessor.setText("");
	        tfcodigoDisciplina.setText("");
	        tfPontuacao.setText("");
	        taInscricaoLista.setText("");

	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Erro ao atualizar inscrição: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
	    }
	}





}

package service;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import br.com.beatrizoliveiralistagenerica.Lista;
import model.Inscricao;
import repository.InscricaoRepository;

public class InscricaoService {
	private InscricaoRepository repository;
	
	public InscricaoService() {
		this.repository = new InscricaoRepository();
	}

	public void cadastraInscricao(Inscricao inscricao) throws IOException{
		if(!(inscricao == null)) {
			repository.salvarInscricao(inscricao);
		}
	}
	
	public Lista<Inscricao> buscaInscricao (Inscricao inscricao, JTextArea taInscricaoLista) throws Exception{
		Lista<Inscricao> inscricoes = new Lista<>();
		if(!inscricao.getCodProcesso().equals("")) {
			return repository.buscarProcesso(inscricao.getCodProcesso());
		} else if (!inscricao.getCpfProfessor().equals("")) {
			return repository.buscarProfessor(inscricao.getCpfProfessor());
		} else {
			JOptionPane.showMessageDialog(null, "Preencha um campo", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		int tamanhoLista = inscricoes.size();
		StringBuffer buffer = new StringBuffer();
		if(tamanhoLista > 0) {
			for(int j = 0; j < tamanhoLista; j++) {
				Inscricao i = (Inscricao) inscricoes.get(j);
				buffer.append("Processo: " + i.getCodProcesso() + " - CPF do Candidato: " + i.getCpfProfessor() + " - Disciplina: " + i.getCodigoDisciplina() + " - Pontuação: " + i.getPontuacao() + "\r\n");
			}
			taInscricaoLista.setText(buffer.toString());
		}
		return null;
	}
 
}

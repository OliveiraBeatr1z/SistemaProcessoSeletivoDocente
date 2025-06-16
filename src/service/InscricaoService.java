package service;

import java.io.IOException;

import javax.swing.JOptionPane;

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
	
	 public Lista<Inscricao> buscarInscricoes(Inscricao filtro) throws IOException {
        if (!filtro.getCodProcesso().equals("")) {
            return repository.buscarPorProcesso(filtro.getCodProcesso());
        } else if (!filtro.getCpfProfessor().equals("")) {
            return repository.buscarProfessor(filtro.getCpfProfessor());
        } else {
        	JOptionPane.showMessageDialog(null, "Preencha um campo", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return new Lista<>(); 
	 }
	 
	 public void removerInscricao(String codProcesso, String cpfProfessor) throws Exception {
		    Lista<Inscricao> inscricoes = repository.buscarPorProcesso(codProcesso);

		    boolean encontrada = false;
		    if (inscricoes != null) {
		        for (int i = 0; i < inscricoes.size(); i++) {
		            Inscricao inscricao = inscricoes.get(i);
		            if (inscricao.getCpfProfessor().equals(cpfProfessor)) {
		                encontrada = true;
		                break;
		            }
		        }
		        if (encontrada) {
			        repository.removerInscricao(codProcesso, cpfProfessor);
			    } else {
			    	JOptionPane.showMessageDialog(null, "Inscrição não encontrada para esse processo e CPF.", "ERRO", JOptionPane.ERROR_MESSAGE);
			    }
		    }

		}

 
}

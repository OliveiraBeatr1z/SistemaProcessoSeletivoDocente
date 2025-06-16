package service;

import java.io.IOException;

import model.Inscricao;
import repository.InscricaoRepository;

public class InscricaoService {
	private InscricaoRepository repository;
	
	public InscricaoService() {
		this.repository = new InscricaoRepository();
	}

	public void cadastraInscricao(Inscricao inscricao) throws IOException{
		repository.salvarInscricao(inscricao);
	}
	
	public Inscricao buscaInscricao (String codProcesso) throws IOException{
		return repository.buscarProcesso(codProcesso);
	}

}

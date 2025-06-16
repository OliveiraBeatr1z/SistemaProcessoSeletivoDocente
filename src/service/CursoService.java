package service;

import java.io.IOException;

import javax.swing.JOptionPane;

import br.com.beatrizoliveiralistagenerica.Lista;
import model.Curso;
import repository.CursoRepository;

public class CursoService {
	
	private CursoRepository repository;
	
	public CursoService() {
		this.repository = new CursoRepository();
	}

	public void cadastrarCurso(Curso curso) throws IOException {
		if(!(curso == null)) {
			repository.salvarCurso(curso);
		}
	}

	public Lista<Curso> buscarCursos(Curso curso) throws IOException {
		if(!curso.getCodigoCurso().isBlank()) {
			return repository.buscarPorCodCurso(curso.getCodigoCurso());
		}else if(!curso.getNomeCurso().isBlank()) {
			return repository.buscarPorNomeCurso(curso.getNomeCurso());
		}else if(!curso.getAreaConhecimentoCurso().isBlank()) {
			return repository.buscarPorAreaConhecimentoCurso(curso.getAreaConhecimentoCurso());
		} else {
			JOptionPane.showMessageDialog(null, "Preencha um campo", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		return new Lista<>();
	}
	
	public void atualizarCurso(Curso curso) throws IOException {
	    repository.atualizarCurso(curso);
	}

	public void removerCurso(String codigoCurso) throws IOException {
	    repository.removerCurso(codigoCurso);
	}


}

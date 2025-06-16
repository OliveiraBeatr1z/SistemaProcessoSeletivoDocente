package service;

import model.Disciplina;
import repository.DisciplinaRepository;

import java.io.IOException;

import br.com.beatrizoliveiralistagenerica.Lista;

public class DisciplinaService {
    private DisciplinaRepository repository;
   
    public DisciplinaService() {
        this.repository = new DisciplinaRepository();
    }

    public void cadastrarDisciplina(Disciplina disciplina) throws IOException {
        repository.salvarDisciplina(disciplina);
    }

    public Disciplina buscarPorCodigo(String codigo) throws IOException {
        return repository.buscarPorCodigo(codigo);
    }

    public Lista<Disciplina> listarDisciplinas() throws Exception {
        return repository.listarTodas();
    }
    
    public void atualizarDisciplina(Disciplina disciplina) throws IOException {
        repository.atualizarDisciplina(disciplina);
    }

    public void removerDisciplina(String codigo) throws IOException {
        repository.removerDisciplina(codigo);
    }

}

package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.beatrizoliveiralistagenerica.Lista;
import model.Professor;

public class ProfessorRepository {
	
	public Lista<Professor> listarProfessores() {
        Lista <Professor> professores = new Lista<>();

        try (BufferedReader br = new BufferedReader(new FileReader("professores.csv"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                String cpf = dados[0];
                String area = dados[1];
                double pontuacao = Double.parseDouble(dados[2]);

                Professor p = new Professor(cpf, area, pontuacao);
                professores.adicionar(p); // ou o método equivalente da sua lista
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return professores;
    }

    public void salvarProfessor(Professor professor) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("professores.csv", true))) {
            String linha = professor.getCpf() + ";" + professor.getAreaConhecimento() + ";" + professor.getPontuacao();
            bw.write(linha);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

}

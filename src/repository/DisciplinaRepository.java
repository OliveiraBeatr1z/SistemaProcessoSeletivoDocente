package repository;

import java.io.*;

import br.com.beatrizoliveiralistagenerica.Lista;
import model.Disciplina;

public class DisciplinaRepository {
    private final String path = System.getProperty("user.home") + File.separator + "SistemaPSD";
    private final String arquivo = "disciplinas.csv";

    public void salvarDisciplina(Disciplina disciplina) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) dir.mkdir();

        File arq = new File(path, arquivo);

        try (FileWriter fw = new FileWriter(arq, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(disciplina.toString());
        }
    }

    public Disciplina buscarPorCodigo(String codigo) throws IOException {
        File arq = new File(path, arquivo);
        if (!arq.exists()) return null;

        try (BufferedReader br = new BufferedReader(new FileReader(arq))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados[0].equals(codigo)) {
                    Disciplina d = new Disciplina();
                    d.setCodigoDisciplina(dados[0]);
                    d.setNomeDisciplina(dados[1]);
                    d.setDiaDisciplina(dados[2]);
                    d.setHoraAulaDisciplina(Integer.parseInt(dados[4]));
                    d.setDuracaoAula(Integer.parseInt(dados[4]));
                    return d;
                }
            }
        }

        return null;
    }

    public Lista<Disciplina> listarTodas() throws Exception {
        Lista<Disciplina> lista = new Lista<>();
        File arq = new File(path, arquivo);
        if (!arq.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(arq))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 5) {
                    Disciplina d = new Disciplina();
                    d.setCodigoDisciplina(dados[0]);
                    d.setNomeDisciplina(dados[1]);
                    d.setDiaDisciplina(dados[2]);
                    d.setHoraAulaDisciplina(Integer.parseInt(dados[3]));
                    d.setDuracaoAula(Integer.parseInt(dados[4]));
                    lista.addLast(d);
                }
            }
        }

        return lista;
    }

    public void atualizarDisciplina(Disciplina disciplina) throws IOException {
        File arq = new File(path, arquivo);
        File tempFile = new File(path, "temp_disciplinas.csv");

        try (
            BufferedReader br = new BufferedReader(new FileReader(arq));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile))
        ) {
            String linha;
            boolean atualizado = false;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 5 && dados[0].equals(disciplina.getCodigoDisciplina())) {
                    pw.println(disciplina.toString()); // atualiza
                    atualizado = true;
                } else {
                    pw.println(linha); // mantém os demais
                }
            }

            if (!atualizado) {
                pw.println(disciplina.toString()); // se não encontrou, adiciona
            }
        }

        if (arq.delete()) {
            tempFile.renameTo(arq);
        } else {
            throw new IOException("Erro ao excluir o arquivo original.");
        }
    }

    public void removerDisciplina(String codigo) throws IOException {
        File arq = new File(path, arquivo);
        File tempFile = new File(path, "temp_disciplinas.csv");

        try (
            BufferedReader br = new BufferedReader(new FileReader(arq));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile))
        ) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (!dados[0].equals(codigo)) {
                    pw.println(linha); // mantém disciplinas com código diferente
                }
            }
        }

        if (arq.delete()) {
            tempFile.renameTo(arq);
        } else {
            throw new IOException("Erro ao excluir o arquivo original.");
        }
    }
}

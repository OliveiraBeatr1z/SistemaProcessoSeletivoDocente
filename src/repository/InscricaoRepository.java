package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import br.com.beatrizoliveiralistagenerica.Lista;
import model.Inscricao;

public class InscricaoRepository {
    private final String path = System.getProperty("user.home") + File.separator + "SistemaPSD";
    private final String  arquivo = "inscricao.csv";

    public void salvarInscricao(Inscricao inscricao) throws IOException {
		File dir = new File(path);
		if(!dir.exists()) dir.mkdir();
		
		File arq = new File(path, arquivo);
		boolean existe = arq.exists();
		
		try(FileWriter fw = new FileWriter(arq, existe);
			PrintWriter pw = new PrintWriter(fw)){
			pw.write(inscricao.toString() + "\r\n");
		}
	}

    public Lista<Inscricao> buscarPorProcesso(String codProcesso) throws IOException {
        Lista<Inscricao> inscricoes = new Lista<>();
        File arq = new File(path, arquivo);

        if (arq.exists() && arq.isFile()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arq)))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    String[] dados = linha.split(";");
                    if (dados.length >= 4 && dados[0].trim().equals(codProcesso)) {
                        Inscricao i = new Inscricao();
                        i.setCodProcesso(dados[0].trim());
                        i.setCpfProfessor(dados[1].trim());
                        i.setCodigoDisciplina(dados[2].trim());
                        i.setPontuacao(dados[3].trim());
                        inscricoes.addFirst(i);
                    }
                }
            }
        }
        return inscricoes;
    }


    public Lista<Inscricao> buscarProfessor(String cpfProfessor) throws IOException {
        File arq = new File(path,arquivo);
        Lista<Inscricao> inscricoes = new Lista<>();
        
		if(arq.exists() && arq.isFile()) {
			try(BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(arq)))) {
				String linha;
				while ((linha = br.readLine()) != null) {
				    String[] dados = linha.split(";");
				    if (dados.length >= 4) {
					    if(dados[1].equals(cpfProfessor)) {
					        Inscricao inscricao = new Inscricao();
					        inscricao.setCodProcesso(dados[0]);
					        inscricao.setCpfProfessor(dados[1]);
					        inscricao.setCodigoDisciplina(dados[2]);
					        inscricao.setPontuacao(dados[3]);
	
					        inscricoes.addFirst(inscricao);
					        System.out.println(inscricoes);
					    }
				    }
				}
			}
		}
		return inscricoes;
    }
    
    public void removerInscricao(String codProcesso, String cpfProfessor) throws Exception {
        File arq = new File(path, arquivo);
        Lista<Inscricao> inscricoesRestantes = new Lista<>();

        if (arq.exists() && arq.isFile()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arq)))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    String[] dados = linha.split(";");
                    if (dados.length == 4) {
                        // Faz comparações limpando espaços extras
                        if (!dados[0].trim().equals(codProcesso.trim()) || !dados[1].trim().equals(cpfProfessor.trim())) {
                            Inscricao i = new Inscricao();
                            i.setCodProcesso(dados[0].trim());
                            i.setCpfProfessor(dados[1].trim());
                            i.setCodigoDisciplina(dados[2].trim());
                            i.setPontuacao(dados[3].trim());

                            inscricoesRestantes.addLast(i);
                        }
                    }
                }
            }

            // Sobrescreve o arquivo com as inscrições restantes
            try (FileWriter fw = new FileWriter(arq, false);
                 PrintWriter pw = new PrintWriter(fw)) {
                for (int i = 0; i < inscricoesRestantes.size(); i++) {
                    pw.write(inscricoesRestantes.get(i).toString() + "\r\n");
                }
            }
        }
    }
    
    public void atualizarInscricao(String codProcesso, String cpfProfessor, String novaDisciplina, String novaPontuacao) throws Exception {
        File arq = new File(path, arquivo);
        Lista<Inscricao> inscricoesAtualizadas = new Lista<>();

        if (arq.exists() && arq.isFile()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arq)))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    String[] dados = linha.split(";");
                    if (dados.length == 4) {
                        Inscricao i = new Inscricao();
                        i.setCodProcesso(dados[0].trim());
                        i.setCpfProfessor(dados[1].trim());

                        if (dados[0].equals(codProcesso) && dados[1].equals(cpfProfessor)) {
                            i.setCodigoDisciplina(novaDisciplina);
                            i.setPontuacao(novaPontuacao);
                        } else {
                            i.setCodigoDisciplina(dados[2].trim());
                            i.setPontuacao(dados[3].trim());
                        }

                        inscricoesAtualizadas.addLast(i);
                    }
                }
            }

            try (FileWriter fw = new FileWriter(arq, false);
                 PrintWriter pw = new PrintWriter(fw)) {
                for (int i = 0; i < inscricoesAtualizadas.size(); i++) {
                    pw.write(inscricoesAtualizadas.get(i).toString() + "\r\n");
                }
            }
        }
    }


  }



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

    public Lista<Inscricao> buscarProcesso(String codProcesso) throws IOException {
        File arq = new File(path,arquivo);
        Inscricao inscricao = new Inscricao();
        Lista<Inscricao> inscricoes = new Lista<>();

		if(arq.exists() && arq.isFile()) {
			try(BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(arq)))) {
				String linha;
				while ((linha = br.readLine()) != null) {
					String[] vetLinha = linha.split(";");
					if(vetLinha[0].equals(codProcesso)) {
						inscricao.setCodProcesso(vetLinha[0]);
						inscricao.setCpfProfessor(vetLinha[1]);
						inscricao.setCodigoDisciplina(vetLinha[2]);
                        inscricao.setPontuacao(vetLinha[3]);
                        
                        inscricoes.addFirst(inscricao);
					}
					 linha = br.readLine();
				}
			}
			return inscricoes;
		}
		return null;
    }

    public Lista<Inscricao> buscarProfessor(String cpfProfessor) throws IOException {
        File arq = new File(path,arquivo);
        Inscricao inscricao = new Inscricao();
        Lista<Inscricao> inscricoes = new Lista<>();
		if(arq.exists() && arq.isFile()) {
			try(BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(arq)))) {
				String linha;
				while ((linha = br.readLine()) != null) {
					String[] vetLinha = linha.split(";");
					if(vetLinha[1].equals(cpfProfessor)) {
						inscricao.setCodProcesso(vetLinha[0]);
						inscricao.setCpfProfessor(vetLinha[1]);
						inscricao.setCodigoDisciplina(vetLinha[2]);
                        inscricao.setPontuacao(vetLinha[3]);

                        inscricoes.addFirst(inscricao);
					}
                    linha = br.readLine();
				}
				return inscricoes;
			}
		}
		return null;
    }


}

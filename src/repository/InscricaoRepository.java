package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import br.com.beatrizoliveiralistagenerica.Lista;
import model.Inscricao;
import model.Professor;

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

    public Inscricao buscarProcesso(String codProcesso) throws IOException {
        File arq = new File(path,arquivo);
        Inscricao inscricao = new Inscricao();

		if(arq.exists() && arq.isFile()) {
			try(BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(arq)))) {
				String linha;
				while ((linha = br.readLine()) != null) {
					String[] dados = linha.split(";");
					if(dados[0].equals(codProcesso)) {
						inscricao.setCodProcesso(dados[0]);
						inscricao.setCpfProfessor(dados[1]);
						inscricao.setCodigoDisciplina(dados[2]);
                        inscricao.setPontuacao(dados[3]);
						return inscricao;
					} else{
                        inscricao = null;
                    }
				}
			}
					
		}
		return null;
    }

    public Inscricao buscarProfessor(String cpfProfessor) throws IOException {
        File arq = new File(path,arquivo);
        Inscricao inscricao = new Inscricao();
        Lista listaInscricao = new Lista();
		if(arq.exists() && arq.isFile()) {
			try(BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(arq)))) {
				String linha;
				while ((linha = br.readLine()) != null) {
					String[] dados = linha.split(";");
					if(dados[1].equals(cpfProfessor)) {
						inscricao.setCodProcesso(dados[0]);
						inscricao.setCpfProfessor(dados[1]);
						inscricao.setCodigoDisciplina(dados[2]);
                        inscricao.setPontuacao(dados[3]);

                        listaInscricao.addFirst(inscricao);
					}
                    linha = br.readLine();
				}
                return inscricao;
			}
					
		}
		return null;
    }


}

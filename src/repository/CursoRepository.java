package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import br.com.beatrizoliveiralistagenerica.Lista;
import model.Curso;

public class CursoRepository {
    private final String path = System.getProperty("user.home") + File.separator + "SistemaPSD";
    private final String  arquivo = "curso.csv";
    
	public void salvarCurso(Curso curso) throws IOException {
		File dir = new File(path);
		if(!dir.exists()) dir.mkdir();
		
		File arq = new File(path, arquivo);
		boolean existe = arq.exists();
		
		try(FileWriter fw = new FileWriter(arq, existe);
			PrintWriter pw = new PrintWriter(fw)){
			pw.write(curso.toString() + "\r\n");
		}
	}	

	public Lista<Curso> buscarPorCodCurso(String codigoCurso) throws IOException {
		 Lista<Curso> cursos = new Lista<>();
	        File arq = new File(path, arquivo);

	        if (arq.exists() && arq.isFile()) {
	            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arq)))) {
	                String linha;
	                while ((linha = br.readLine()) != null) {
	                    String[] dados = linha.split(";");
	                    if (dados.length >= 4 && dados[0].equals(codigoCurso)) {
	                        Curso c = new Curso();
	                        c.setCodigoCurso(dados[0]);
	                        c.setNomeCurso(dados[1]);
	                        c.setAreaConhecimentoCurso(dados[2]);
	                        cursos.addFirst(c);
	                    }
	                }
	            }
	        }
	        return cursos;
	}

	public Lista<Curso> buscarPorNomeCurso(String nomeCurso) throws IOException {
		Lista<Curso> cursos = new Lista<>();
        File arq = new File(path, arquivo);

        if (arq.exists() && arq.isFile()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arq)))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    String[] dados = linha.split(";");
                    if (dados.length >= 4 && dados[1].equals(nomeCurso)) {
                        Curso c = new Curso();
                        c.setCodigoCurso(dados[0]);
                        c.setNomeCurso(dados[1]);
                        c.setAreaConhecimentoCurso(dados[2]);
                        cursos.addFirst(c);
                    }
                }
            }
        }
        return cursos;
	}

	public Lista<Curso> buscarPorAreaConhecimentoCurso(String areaConhecimentoCurso) throws IOException {
		Lista<Curso> cursos = new Lista<>();
        File arq = new File(path, arquivo);

        if (arq.exists() && arq.isFile()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arq)))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    String[] dados = linha.split(";");
                    if (dados.length >= 4 && dados[2].equals(areaConhecimentoCurso)) {
                        Curso c = new Curso();
                        c.setCodigoCurso(dados[0]);
                        c.setNomeCurso(dados[1]);
                        c.setAreaConhecimentoCurso(dados[2]);
                        cursos.addFirst(c);
                    }
                }
            }
        }
        return cursos;
	}
	
	
}

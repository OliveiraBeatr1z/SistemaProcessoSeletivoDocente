package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import model.Professor;

public class ProfessorRepository {
	private final String path = System.getProperty("user.home") + File.separator + "SistemaPSD";
	private final String  arquivo = "professor.csv";
	
//	public void salvarProfessor(Professor professor) throws IOException {
//		File dir = new File(path);
//		if(!dir.exists()) dir.mkdir();
//		
//		File arq = new File(path, arquivo);
//		boolean existe = arq.exists();
//		
//		try(FileWriter fw = new FileWriter(arq, existe);
//			PrintWriter pw = new PrintWriter(fw)){
//			pw.write(professor.toString() + "\r\n");
//		}
//	}
	
	public Professor buscaPorCpf(String cpf) throws IOException {
		File arq = new File(path,arquivo);
		
		if(arq.exists() && arq.isFile()) {
			try(BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(arq)))) {
				String linha;
				while ((linha = br.readLine()) != null) {
					String[] dados = linha.split(";");
					if(dados[0].equals(cpf)) {
						Professor professor = new Professor();
						professor.setCpf(dados[0]);
						professor.setNome(dados[1]);
						professor.setAreaConhecimento(dados[2]);
						return professor;
					}
				}
			}
					
		}
		return null;
	}
	
	public void salvarProfessor(Professor professor) throws IOException {
	    File arq = new File(path, arquivo);
	    File tempFile = new File(path, "temp_professor.csv");

	    try (
	        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arq)));
	        PrintWriter pw = new PrintWriter(new FileWriter(tempFile))
	    ) {
	        String linha;
	        boolean atualizado = false;

	        while ((linha = br.readLine()) != null) {
	            String[] dados = linha.split(";");
	            if (dados.length >= 3 && dados[0].equals(professor.getCpf())) {
	                pw.println(professor.toString());  // atualiza
	                atualizado = true;
	            } else {
	                pw.println(linha);  // mantém os demais
	            }
	        }

	        if (!atualizado) {
	            pw.println(professor.toString()); // se não encontrou, adiciona novo
	        }
	    }

	    arq.delete();
	    tempFile.renameTo(arq);
	}
	
	public void removerProfessor(String cpf) throws IOException {
	    File arq = new File(path, arquivo);
	    File tempFile = new File(path, "temp_professor.csv");

	    try (
	        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arq)));
	        PrintWriter pw = new PrintWriter(new FileWriter(tempFile))
	    ) {
	        String linha;

	        while ((linha = br.readLine()) != null) {
	            String[] dados = linha.split(";");
	            if (dados.length >= 3 && !dados[0].equals(cpf)) {
	                pw.println(linha); // copia somente linhas com CPF diferente
	            }
	        }
	    }

	    arq.delete();
	    tempFile.renameTo(arq);
	}


}



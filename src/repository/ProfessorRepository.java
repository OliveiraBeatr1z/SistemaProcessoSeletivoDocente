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
	
	public void salvar(Professor professor) throws IOException {
		File dir = new File(path);
		if(!dir.exists()) dir.mkdir();
		
		File arq = new File(path, arquivo);
		boolean existe = arq.exists();
		
		try(FileWriter fw = new FileWriter(arq, existe);
			PrintWriter pw = new PrintWriter(fw)){
			pw.write(professor.getCpf() +";"+  professor.getNome() +"; "+ professor.getAreaConhecimento() + "\r\n");
		}
	}
	
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

}



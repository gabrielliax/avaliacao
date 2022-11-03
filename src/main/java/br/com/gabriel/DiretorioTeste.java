package br.com.gabriel;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.gabriel.model.ArquivoDiretorio;
import br.com.gabriel.repository.ArquivoDiretorioRepository;

@Controller
public class DiretorioTeste {

	int grau = 1, ultimaHierarquiaConsultada = 0;
	String continuar = "S";
	Scanner ler = new Scanner(System.in);

	@Autowired
	private ArquivoDiretorioRepository arquivoDiretorioRepository;
	
	public File lerCaminho(String caminhoS) {

		File caminho = new File(caminhoS);
		return caminho;

	}

	public int lerProfundidade() {

		int profundidade;
		System.out.println("Profundidade: ");
		profundidade = ler.nextInt();

		return profundidade;
	}

	public void criarHirarquia(File caminho, int profundidade) {

		File listaArquivos[] = caminho.listFiles();
		
		//comparar a profundidade inserida com a ultima que foi cadastrada, e não com o grau 
		if (profundidade > ultimaHierarquiaConsultada || ultimaHierarquiaConsultada == 0) {			
			if (grau <= profundidade) {
				if (listaArquivos != null) {
					for (File arquivo : listaArquivos) {
						if (arquivo.isDirectory()) {
							ArquivoDiretorio arquivoDiretorio = new ArquivoDiretorio(arquivo.getName(), grau, "Diretorio");
							arquivoDiretorioRepository.save(arquivoDiretorio);
							
							System.out.println(calculaGrau(grau) + arquivo.getName() + "(Diretório)");
							grau++;
							criarHirarquia(arquivo, profundidade);

						} else {
							ArquivoDiretorio arquivoDiretorio = new ArquivoDiretorio(arquivo.getName(), grau, "Arquivo");
							arquivoDiretorioRepository.save(arquivoDiretorio);
							System.out.println(calculaGrau(grau) + arquivo.getName().toString() + " (Arquivo)");
						}
					}
				}
			}
			grau--;
		} else {
			List<ArquivoDiretorio> arquivosDiretorios = arquivoDiretorioRepository.findByProfundidade(profundidade);
		}
	}

	public String calculaGrau(int grau) {

		int equacao = (grau - 1) * 4;
		String hashs = "";
		for (int i = 1; i <= equacao; i++) {
			hashs += "#";
		}

		return hashs + grau + " - ";

	}

	public void metodoPrincipal(String caminho2, Integer profundidade2) {
		
		//while deveria ficar aqui 
		File caminho = lerCaminho(caminho2);
		
		if(profundidade2 > ultimaHierarquiaConsultada) {
			arquivoDiretorioRepository.deleteAll();
		}
		criarHirarquia(caminho, profundidade2); 
		//depois que acaba a logica, sobrepoem a ultima hierarquia consultada
		this.ultimaHierarquiaConsultada = profundidade2;
		this.grau = 1;
		

	}

}

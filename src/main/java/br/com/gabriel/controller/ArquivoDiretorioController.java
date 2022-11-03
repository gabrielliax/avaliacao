package br.com.gabriel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.DiretorioTeste;
import br.com.gabriel.dto.RequestArquivo;

@RestController
@RequestMapping
public class ArquivoDiretorioController {

	@Autowired
	private DiretorioTeste diretorio;
	
	@RequestMapping("/arquivo")
	public String init(@RequestBody RequestArquivo dto) {
		diretorio.metodoPrincipal(dto.getCaminho(), dto.getProfundidade());
		return "Ok";
	}
}

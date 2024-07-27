package br.com.alelvis3.sysAlelvisTec.dto;

import br.com.alelvis3.sysAlelvisTec.model.Uf;

public record EnderecoDto(String cep,
	    String logradouro,
	    String complemento,
	    String bairro,
	    String localidade,
	    Uf uf,
	    String numero) {
}
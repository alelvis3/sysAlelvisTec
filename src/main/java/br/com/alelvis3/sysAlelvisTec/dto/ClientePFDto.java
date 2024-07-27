package br.com.alelvis3.sysAlelvisTec.dto;

public record ClientePFDto(Long id,
	    String nome,
	    String email,
	    String telefone,
	    String cpf,
	    EnderecoDto endereco,
	    Boolean ativo) {

}

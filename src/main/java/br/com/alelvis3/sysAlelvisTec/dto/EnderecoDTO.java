package br.com.alelvis3.sysAlelvisTec.dto;

import br.com.alelvis3.sysAlelvisTec.model.Uf;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
	    
	    @NotBlank(message = "Logradouro é obrigatório")
	    String logradouro, // Nome da rua/avenida. Exemplo: "Rua das Flores"
	    
	    @NotBlank(message = "Bairro é obrigatório")
	    String bairro, // Nome do bairro. Exemplo: "Centro"
	    
	    @NotBlank(message = "CEP é obrigatório")
	    @Pattern(regexp = "\\d{8}", message = "CEP deve conter 8 dígitos")
	    String cep, // Código de Endereçamento Postal. Exemplo: "12345678"
	    
	    @NotBlank(message = "Cidade é obrigatória")
	    String cidade, // Nome da cidade. Exemplo: "São Paulo"
	    
	    Uf uf, // Unidade Federativa (Estado). Exemplo: Uf.SP
	    
	    String complemento, // Complemento do endereço (opcional). Exemplo: "Apto 101"
	    
	    String numero // Número do endereço. Exemplo: "123"
	) {
	}
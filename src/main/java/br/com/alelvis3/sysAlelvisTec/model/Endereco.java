package br.com.alelvis3.sysAlelvisTec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
	@Column(length = 9)
	private String cep;

	private String logradouro;

	private String complemento;

	private String bairro;

	@Column(length = 50)
	private String localidade;

	@Enumerated
	private Uf uf;

	@Column(length = 10)
	private String numero;
}

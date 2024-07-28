package br.com.alelvis3.sysAlelvisTec.dto;

import br.com.alelvis3.sysAlelvisTec.model.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientePfDTO {

    private Long id; // O ID será gerado automaticamente pelo sistema e não deve ser fornecido na criação

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String nome; // Nome do cliente com validação de tamanho
    // Exemplo: "João da Silva"

    @Email(message = "Email deve ser válido")
    @NotBlank(message = "Email é obrigatório")
    @Size(max = 100, message = "Email deve ter no máximo 100 caracteres")
    private String email; // Email do cliente com validação de formato e tamanho
    // Exemplo: "joao.silva@example.com"

    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(regexp = "^[0-9]{10,11}$", message = "Telefone deve ser válido e conter 10 ou 11 dígitos")
    private String telefone; // Telefone do cliente com validação de formato
    // Exemplo: "11912345678" ou "1191234567"

    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "^[0-9]{11}$", message = "CPF deve ser válido e conter 11 dígitos")
    private String cpf; // CPF do cliente com validação de formato
    // Exemplo: "12345678901"

    private Endereco endereco; // Endereço do cliente
   
    }
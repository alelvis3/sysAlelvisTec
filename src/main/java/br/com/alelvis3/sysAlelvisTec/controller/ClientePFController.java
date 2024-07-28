package br.com.alelvis3.sysAlelvisTec.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alelvis3.sysAlelvisTec.dto.ClientePfDTO;
import br.com.alelvis3.sysAlelvisTec.service.ClientePFService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/clientes") // Define o endpoint base para este controlador
@Validated // Habilita a validação nos métodos do controlador
public class ClientePFController {

    @Autowired // Injeta automaticamente uma instância do ClientePFService
    private ClientePFService service;

    @Operation(summary = "Criar um novo cliente") // Descrição do método para a documentação Swagger
    @PostMapping // Mapeia solicitações HTTP POST para este método
    public ResponseEntity<ClientePfDTO> cadastrar(@RequestBody @Valid ClientePfDTO dados,
                                                  UriComponentsBuilder uriBuilder) {
        ClientePfDTO cliente = service.criarCliente(dados); // Chama o serviço para criar um novo cliente
        URI endereco = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri(); // Constrói a URI do novo recurso
        return ResponseEntity.created(endereco).body(cliente); // Retorna a resposta com o status 201 Created e o cliente criado no corpo
    }

    @Operation(summary = "Listar todos os clientes") // Descrição do método para a documentação Swagger
    @GetMapping // Mapeia solicitações HTTP GET para este método
    public ResponseEntity<List<ClientePfDTO>> getAllClientes() {
        List<ClientePfDTO> clientes = service.getAllClientes(); // Chama o serviço para obter todos os clientes
        return ResponseEntity.ok(clientes); // Retorna a resposta com o status 200 OK e a lista de clientes no corpo
    }

    @Operation(summary = "Buscar cliente por ID") // Descrição do método para a documentação Swagger
    @GetMapping("/{id}") // Mapeia solicitações HTTP GET para este método, com um caminho variável
    public ResponseEntity<?> getClienteById(@PathVariable @NotNull Long id) {
        Optional<ClientePfDTO> cliente = service.getClienteById(id); // Chama o serviço para obter um cliente por ID
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get()); // Retorna a resposta com o status 200 OK e o cliente no corpo
        } else {
            return ResponseEntity.status(404).body("Cliente com ID " + id + " não encontrado."); // Retorna a resposta com o status 404 Not Found
        }
    }

    @Operation(summary = "Atualizar cliente por ID") // Descrição do método para a documentação Swagger
    @PutMapping("/{id}") // Mapeia solicitações HTTP PUT para este método, com um caminho variável
    public ResponseEntity<?> updateCliente(@PathVariable @NotNull Long id,
                                           @RequestBody @Valid ClientePfDTO dto) {
        ClientePfDTO clienteAtualizado = service.updateCliente(id, dto); // Chama o serviço para atualizar um cliente
        if (clienteAtualizado != null) {
            return ResponseEntity.ok(clienteAtualizado); // Retorna a resposta com o status 200 OK e o cliente atualizado no corpo
        } else {
            return ResponseEntity.status(404).body("Cliente com ID " + id + " não encontrado para atualização."); // Retorna a resposta com o status 404 Not Found
        }
    }

    @Operation(summary = "Excluir cliente por ID") // Descrição do método para a documentação Swagger
    @DeleteMapping("/{id}") // Mapeia solicitações HTTP DELETE para este método, com um caminho variável
    public ResponseEntity<?> deleteCliente(@PathVariable @NotNull Long id) {
        if (service.deleteCliente(id)) { // Chama o serviço para desativar um cliente
            return ResponseEntity.status(204).body("Cliente com ID " + id + " foi desativado com sucesso."); // Retorna a resposta com o status 204 No Content e uma mensagem de sucesso
        } else {
            return ResponseEntity.status(404).body("Cliente com ID " + id + " não encontrado para desativação."); // Retorna a resposta com o status 404 Not Found
        }
    }
}
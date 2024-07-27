package br.com.alelvis3.sysAlelvisTec.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alelvis3.sysAlelvisTec.dto.ClientePFDto;
import br.com.alelvis3.sysAlelvisTec.service.ClientePFService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClientePFController {

	@Autowired
	private ClientePFService service;

	@Operation(summary = "Criar um novo cliente")
	@PostMapping
	public ResponseEntity<ClientePFDto> cadastrar(@RequestBody @Valid ClientePFDto dto,
			UriComponentsBuilder uriBuilder) {
		ClientePFDto cliente = service.criarCliente(dto);
		URI endereco = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.id()).toUri();
		return ResponseEntity.created(endereco).body(cliente);
	}

//	@Operation(summary = "Listar todos os clientes")
//	@GetMapping
//	public ResponseEntity<List<ClientePFDto>> getAllClientes() {
//		List<ClientePFDto> clientes = service.getAllClientes();
//		return ResponseEntity.ok(clientes);
//	}
//
//	@Operation(summary = "Buscar cliente por ID")
//	@GetMapping("/{id}")
//	public ResponseEntity<ClientePFDto> getClienteById(@PathVariable Long id) {
//		Optional<ClientePFDto> cliente = service.getClienteById(id);
//		return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//	}
//
//	@Operation(summary = "Atualizar cliente por ID")
//	@PutMapping("/{id}")
//	public ResponseEntity<ClientePFDto> updateCliente(@PathVariable Long id, @RequestBody ClientePFDto dto) {
//		ClientePFDto clienteAtualizado = service.updateCliente(id, dto);
//		return clienteAtualizado != null ? ResponseEntity.ok(clienteAtualizado) : ResponseEntity.notFound().build();
//	}
//
//	@Operation(summary = "Excluir cliente por ID")
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
//		service.deleteCliente(id);
//		return ResponseEntity.noContent().build();
//	}
}

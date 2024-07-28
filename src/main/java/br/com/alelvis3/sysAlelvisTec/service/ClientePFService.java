package br.com.alelvis3.sysAlelvisTec.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alelvis3.sysAlelvisTec.dto.ClientePfDTO;
import br.com.alelvis3.sysAlelvisTec.model.ClientePF;
import br.com.alelvis3.sysAlelvisTec.repository.ClientePFRepository;

@Service // Indica que esta classe é um serviço do Spring
public class ClientePFService {

    @Autowired // Injeta automaticamente uma instância do ClientePFRepository
    private ClientePFRepository repository;

    @Autowired // Injeta automaticamente uma instância do ModelMapper
    private ModelMapper modelMapper;

    // Método para criar um novo cliente
    public ClientePfDTO criarCliente(ClientePfDTO dto) {
        ClientePF cliente = modelMapper.map(dto, ClientePF.class); // Mapeia o DTO para a entidade ClientePF
        cliente.setId(null); // Garante que o ID não seja configurado pelo usuário
        cliente.setAtivo(true); // Define o status como ativo
        ClientePF clienteSalvo = repository.save(cliente); // Salva o cliente e obtém o cliente salvo com o ID
        return modelMapper.map(clienteSalvo, ClientePfDTO.class); // Mapeia o cliente salvo para o DTO e o retorna
    }

    // Método para obter todos os clientes
    public List<ClientePfDTO> getAllClientes() {
        List<ClientePF> clientes = repository.findAll(); // Obtém todos os clientes do banco de dados
        return clientes.stream().map(cliente -> modelMapper.map(cliente, ClientePfDTO.class)).toList(); // Mapeia a lista de entidades para uma lista de DTOs
    }

    // Método para obter um cliente por ID
    public Optional<ClientePfDTO> getClienteById(Long id) {
        return repository.findById(id).map(cliente -> modelMapper.map(cliente, ClientePfDTO.class)); // Obtém o cliente por ID e mapeia para o DTO, se presente
    }

    // Método para atualizar um cliente existente
    public ClientePfDTO updateCliente(Long id, ClientePfDTO dto) {
        if (repository.existsById(id)) { // Verifica se o cliente com o ID fornecido existe
            ClientePF cliente = modelMapper.map(dto, ClientePF.class); // Mapeia o DTO para a entidade ClientePF
            cliente.setId(id); // Garante que o ID não seja alterado
            cliente.setAtivo(true); // Mantém o status ativo
            cliente = repository.save(cliente); // Salva o cliente atualizado
            return modelMapper.map(cliente, ClientePfDTO.class); // Mapeia o cliente atualizado para o DTO e o retorna
        }
        return null; // Retorna null se o cliente não existir
    }

    // Método para desativar um cliente (não excluir)
    public boolean deleteCliente(Long id) {
        Optional<ClientePF> clienteOpt = repository.findById(id); // Obtém o cliente por ID, se presente
        if (clienteOpt.isPresent()) {
            ClientePF cliente = clienteOpt.get();
            cliente.setAtivo(false); // Define o status como inativo
            repository.save(cliente); // Salva o cliente com o status atualizado
            return true; // Retorna true indicando que o cliente foi desativado com sucesso
        }
        return false; // Retorna false se o cliente não foi encontrado
    }
}
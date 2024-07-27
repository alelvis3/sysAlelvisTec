package br.com.alelvis3.sysAlelvisTec.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alelvis3.sysAlelvisTec.dto.ClientePFDto;
import br.com.alelvis3.sysAlelvisTec.model.ClientePF;
import br.com.alelvis3.sysAlelvisTec.repository.ClientePFRepository;

@Service
public class ClientePFService {

    @Autowired
    private ClientePFRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public ClientePFDto criarCliente(ClientePFDto dto) {
        ClientePF cliente = modelMapper.map(dto, ClientePF.class);
        cliente.setAtivo(true);
        System.out.println(cliente);
        repository.save(cliente);
        return modelMapper.map(cliente, ClientePFDto.class);
    }

//    public List<ClientePFDto> getAllClientes() {
//        List<ClientePF> clientes = repository.findAll();
//        return clientes.stream().map(cliente -> modelMapper.map(cliente, ClientePFDto.class)).toList();
//    }
//
//    public Optional<ClientePFDto> getClienteById(Long id) {
//        return repository.findById(id).map(cliente -> modelMapper.map(cliente, ClientePFDto.class));
//    }
//
//    public ClientePFDto updateCliente(Long id, ClientePFDto dto) {
//        if (repository.existsById(id)) {
//            ClientePF cliente = modelMapper.map(dto, ClientePF.class);
//            cliente.setId(id);
//            cliente = repository.save(cliente);
//            return modelMapper.map(cliente, ClientePFDto.class);
//        }
//        return null;
//    }
//
//    public void deleteCliente(Long id) {
//        repository.deleteById(id);
//    }
}
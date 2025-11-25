package com.maninho.Sistema.maninho.services;

import com.maninho.Sistema.maninho.dto.*;
import com.maninho.Sistema.maninho.enums.TipoPessoa;
import com.maninho.Sistema.maninho.model.Cliente;
import com.maninho.Sistema.maninho.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteFisicoResponseDTO cadastrarClienteFisico(ClienteFisicoRequestDTO dto) {

        Cliente fisico = dto.toEntity();
        fisico.setTipoPessoa(TipoPessoa.FISICA);
        fisico = clienteRepository.save(fisico);
        return ClienteFisicoResponseDTO.fromEntity(fisico);
    }

    public ClienteJuridicoResponseDTO cadastrarClienteJuridico(ClienteJuridicoRequestDTO dto) {

        Cliente juridico = dto.toEntity();
        juridico.setTipoPessoa(TipoPessoa.JURIDICA);
        juridico = clienteRepository.save(juridico);
        return ClienteJuridicoResponseDTO.fromEntity(juridico);
    }

    public List<Object> buscarTodosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        List<Object> clientesDTO = new ArrayList<>();

        for (Cliente cliente : clientes) {
            if (cliente.getTipoPessoa() == TipoPessoa.FISICA) {
                clientesDTO.add(ClienteFisicoResponseDTO.fromEntity(cliente));
            } else {
                clientesDTO.add(ClienteJuridicoResponseDTO.fromEntity(cliente));
            }
        }

        return clientesDTO;
    }


    public void excluirCliente(Long id) {

        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado com o ID: "+ id));

        clienteRepository.delete(cliente);
    }

    public ClienteFisicoResponseDTO atualizarClienteFisico(Long id, ClienteFisicoRequestDTO dto) {

        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        clienteExistente.setNome(dto.getNome());
        clienteExistente.setCpf(dto.getCpf());
        clienteExistente.setRg(dto.getRg());
        clienteExistente.setEndereco(dto.getEndereco());
        clienteExistente.setBairro(dto.getBairro());
        clienteExistente.setCidade(dto.getCidade());
        clienteExistente.setUf(dto.getUf());
        clienteExistente.setCep(dto.getCep());
        clienteExistente.setNumero(dto.getNumero());

        Cliente clienteAtualizado = clienteRepository.save(clienteExistente);

        return ClienteFisicoResponseDTO.fromEntity(clienteExistente);
    }

    public ClienteJuridicoResponseDTO atualizarClienteJuridico(Long id, ClienteJuridicoRequestDTO dto) {

        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        clienteExistente.setRazaoSocial(dto.getRazaoSocial());
        clienteExistente.setCnpj(dto.getCnpj());
        clienteExistente.setIe(dto.getIe());
        clienteExistente.setEndereco(dto.getEndereco());
        clienteExistente.setBairro(dto.getBairro());
        clienteExistente.setCidade(dto.getCidade());
        clienteExistente.setUf(dto.getUf());
        clienteExistente.setCep(dto.getCep());
        clienteExistente.setNumero(dto.getNumero());

        Cliente clienteAtualizado = clienteRepository.save(clienteExistente);

        return ClienteJuridicoResponseDTO.fromEntity(clienteExistente);
    }

    public List<ClienteAutoCompleteDTO> buscarPorNome(String nome) {
        List<Cliente> clientes = clienteRepository.findByNomeContainingIgnoreCase(nome);
        return clientes.stream().map(cliente -> {
            ClienteAutoCompleteDTO dto = new ClienteAutoCompleteDTO();
            dto.setId(cliente.getId());
            dto.setNome(cliente.getNomeExibicao());
            return dto;
        }).toList();
    }
}

package com.maninho.Sistema.maninho.services;

import com.maninho.Sistema.maninho.dto.ItemPedidoResponseDTO;
import com.maninho.Sistema.maninho.dto.PedidoRequestDTO;
import com.maninho.Sistema.maninho.dto.PedidoResponseDTO;
import com.maninho.Sistema.maninho.enums.TipoPessoa;
import com.maninho.Sistema.maninho.model.Cliente;
import com.maninho.Sistema.maninho.model.ItemPedido;
import com.maninho.Sistema.maninho.model.Pedido;
import com.maninho.Sistema.maninho.model.Produto;
import com.maninho.Sistema.maninho.repositories.ClienteRepository;
import com.maninho.Sistema.maninho.repositories.PedidoRepository;
import com.maninho.Sistema.maninho.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public PedidoResponseDTO criarPedido(PedidoRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        Pedido finalPedido = pedido;
        List<ItemPedido> itens = dto.getItens().stream().map(itemDto -> {
            Produto produto = produtoRepository.findById(itemDto.getProdutoId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

            ItemPedido item = new ItemPedido();
            item.setProduto(produto);
            item.setQuantidade(itemDto.getQuantidade());
            item.setPrecoUnitario(produto.getPreco()); // pega o preço do produto

            item.setPedido(finalPedido); // muito importante
            return item;
        }).toList();

        pedido.setItens(itens);
        pedido.setDataCriacao(LocalDate.now());
        pedido.setDataVencimento(dto.getDataVencimento());

        pedido = pedidoRepository.save(pedido);


        PedidoResponseDTO response = new PedidoResponseDTO();
        response.setId(pedido.getId());
        response.setNomeCliente(pedido.getCliente().getNomeExibicao());

        if (cliente.getTipoPessoa()== TipoPessoa.FISICA){
            response.setDocumento1(pedido.getCliente().getCpf());
            response.setDocumento2(pedido.getCliente().getRg());
        } else if (cliente.getTipoPessoa()== TipoPessoa.JURIDICA){
            response.setDocumento1(pedido.getCliente().getCnpj());
            response.setDocumento2(pedido.getCliente().getIe().toString());
        }

        response.setEndereco(pedido.getCliente().getEndereco());
        response.setNumero(pedido.getCliente().getNumero());
        response.setBairro(pedido.getCliente().getBairro());
        response.setCep(pedido.getCliente().getCep());
        response.setCidade(pedido.getCliente().getCidade());
        response.setUf(pedido.getCliente().getUf());
        response.setItens(pedido.getItens().stream().map(item -> {
            ItemPedidoResponseDTO itemResp = new ItemPedidoResponseDTO();
            itemResp.setNomeProduto(item.getProduto().getNome());
            itemResp.setQuantidade(item.getQuantidade());
            itemResp.setPrecoUnitario(item.getPrecoUnitario());
            return itemResp;
        }).toList());

        response.setValorTotal(pedido.getTotal());
        response.setDataVencimento(pedido.getDataVencimento());
        response.setDataPedido(pedido.getDataCriacao());


        return response;
    }


}

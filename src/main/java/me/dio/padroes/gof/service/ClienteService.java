package me.dio.padroes.gof.service;

import me.dio.padroes.gof.model.Cliente;
import org.springframework.cloud.client.loadbalancer.ClientHttpResponseStatusCodeException;
import org.springframework.stereotype.Service;


public interface ClienteService {

    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);


}

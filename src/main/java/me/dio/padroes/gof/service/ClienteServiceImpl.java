package me.dio.padroes.gof.service;

import me.dio.padroes.gof.model.Cliente;
import me.dio.padroes.gof.model.Endereco;
import me.dio.padroes.gof.repository.ClienteRepository;
import me.dio.padroes.gof.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viacerService;
    @Override
    public Iterable<Cliente> buscarTodos() {

        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return cliente;
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComEndereco(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBD =  clienteRepository.findById(id);

        if(clienteBD.isPresent()){
            salvarClienteComEndereco(cliente);
        } else
            throw new RuntimeException("cliente não encontrado");

    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComEndereco(Cliente cliente){
        String cep =  cliente.getEndereco().getCep();
        //verificação se endereço ja é existente no banco
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viacerService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}

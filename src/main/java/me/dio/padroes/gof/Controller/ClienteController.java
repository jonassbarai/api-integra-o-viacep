package me.dio.padroes.gof.Controller;

import me.dio.padroes.gof.model.Cliente;
import me.dio.padroes.gof.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return  ResponseEntity.ok(clienteService.buscarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(Long id){
        clienteService.deletar(id);
        return  ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> inserir(@PathVariable Long id,@RequestBody Cliente cliente){
       clienteService.atualizar(id,cliente);
       return ResponseEntity.ok(cliente);

    }

}

package me.dio.padroes.gof.repository;

import me.dio.padroes.gof.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco,String> {
}

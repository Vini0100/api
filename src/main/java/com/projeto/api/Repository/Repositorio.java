package com.projeto.api.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.api.model.Pessoa;

@Repository // Para o Spring saber que esta interface é um repositorio
public interface Repositorio extends CrudRepository<Pessoa, Integer> { // CrudRepository Vai auxíliar na criação dos
                                                                       // métodos de CRUD. CrudRepository<Modelo que
                                                                       // será trabalhado, Tipo da chave primaria>
    // O NOME DO MÉTODO faz com que o Spring já dê oque a gente precisa!

    List<Pessoa> findAll(); // Método o qual é utilziado para buscar todos os dados de uma tabela, como por
                            // exemplo a GETMapping /api da Classe Pessoa

    Pessoa findByCodigo(int codigo); // Método utilziado para buscar na tabela do banco de dados somente pelo código
                                     // da Pessoa

    List<Pessoa> findByOrderByNome(); // findByOrderByNomeDesc ORDENA AO CONTRÁRIO

    List<Pessoa> findByNomeOrderByIdadeDesc(String nome); // Procura por Nome e Ordena por Idade

    List<Pessoa> findByNomeContaining(String termo); // Procura por um Termo específico

    List<Pessoa> findByNomeStartingWith(String termo); // Começa com

    List<Pessoa> findByNomeEndsWith(String termo); // Termina com

    @Query(value = "SELECT SUM(idade) FROM pessoas", nativeQuery = true)
    int somaIdade(); // Alteração do tipo de retorno para Integer

    @Query(value = "SELECT * FROM pessoas WHERE idade >= :idade", nativeQuery = true)
    List<Pessoa> idadeMaiorIgual(int idade); // Todas as idade maiores ou iguais a int idade que está aqui, vão ser
                                             // resgatadas

    int countByCodigo(int codigo);
}

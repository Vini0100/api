package com.projeto.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.api.Repository.Repositorio;
import com.projeto.api.model.Pessoa;
import com.projeto.api.model.Cliente;
import com.projeto.api.services.Servico;

import jakarta.validation.Valid;

@RestController // A classe é um controle de rota
public class Controller {

    @Autowired // Não será necessário instaciar acao, o próprio Autowired fará isto. Isto é
               // Injeção de dependências
    private Repositorio acao; // Vai ajudar nas operação CRUD

    @Autowired
    private Servico servico; // Serviços para as operações. Estes serviços ajudarão nas validações

    @PostMapping("/api") // Annotation utilizada para criar uma rota com suporte a requisição post
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa obj) { // ResponseEntity pois pode não dar certo conforme o
                                                                  // "servico"
        return servico.cadastrar(obj); // Valida pelo "servico" e Salva a Pessoa utilizando o repositório injetado e
                                       // retorna a Pessoa
        // cadastrada
    }

    @GetMapping("/api") // Toda vez que acessar a "/api" e fizermos um requisição GET, serão lsitados os
                        // dados da entidade pessoas
    public ResponseEntity<?> selecionar() {
        return servico.selecionar();// Servico valida e após isto, traz as informações e da OK na requisição HTTP
    }

    @GetMapping("/api/{codigo}") //
    public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo) {
        return servico.selecionarPeloCodigo(codigo);// Chama o serviço "selecionarPeloCodigo", que após validar chama o
                                                    // método findByCodigo o qual é acessado diretamente pela "acao",
        // buscando a informação no banco dados
    }

    @PutMapping("/api") // Put irá servir para editar um dado, mas é necessário passar o objeto inteiro
    public ResponseEntity<?> editar(@RequestBody Pessoa obj) {
        return servico.editar(obj); // Servico irá validar as informações e depois passará ou não para o repositório
                                    // através do acao.save
    }

    @DeleteMapping("/api/{codigo}") // Deleta pelo Codigo
    public ResponseEntity<?> remover(@PathVariable int codigo) {
        return servico.remover(codigo); // Serviço irá validar se o código existe e irá deletar atrvés do
                                        // "servico.remover"
    }

    @GetMapping("/api/contador")
    public long contador() { // Um contador de Pessoas na Entidade Pessoa
        return acao.count();// não é necessário do método na classe repositório
    }

    @GetMapping("/api/ordenarNomes")
    public List<Pessoa> ordenarNomes() {
        return acao.findByOrderByNome();
    }

    @GetMapping("/api/ordenarNomes2")
    public List<Pessoa> ordernarNomes2() {
        return acao.findByNomeOrderByIdadeDesc("Lorenzo"); // Nomes == Lorenzo e Ordena por Ordem Decrescente de idade
    }

    @GetMapping("/api/nomeContem")
    public List<Pessoa> nomeContem() {
        return acao.findByNomeContaining("o"); // Nomes que contem "o"
    }

    @GetMapping("/api/iniciaCom")
    public List<Pessoa> iniciaCom() {
        return acao.findByNomeStartingWith("a");
    }

    @GetMapping("/api/terminaCom")
    public List<Pessoa> terminaCom() {
        return acao.findByNomeEndsWith("a");
    }

    @GetMapping("/api/somaIdades")
    public int somaIdades() { // Alteração do tipo de retorno para Integer
        return acao.somaIdade(); // Retorna o resultado da soma de idades
    }

    @GetMapping("/api/idadeMaiorIgual")
    public List<Pessoa> idadeMaiorIgual() { // Alteração do tipo de retorno para Integer
        return acao.idadeMaiorIgual(20); // Retorna o resultado da soma de idades
    }

    @GetMapping("/status")
    public ResponseEntity<?> status() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/cliente")
    public void Cliente(@Valid @RequestBody Cliente obj) { // @Valid para dizer ao Spring que é uma validação(Senão
                                                           // tiver, o email e o nome não irão funionar!)

    }

    // -------------------------------------------

    @GetMapping("") // Este Get mapping é igual ao LocalHost padrão "http://localhost:8080/"
    public String mensagem() {
        return "Hello World";
    }

    @GetMapping("/boasVindas") // Transforma Ao acessar "http://localhost:8080/boasVindas", traz a mensagem do
                               // Return
    public String boasVindas() {
        return "Seja bem vindo(a) ";
    }

    @GetMapping("/boasVindas/{nome}") // Transforma o {nome} em uma variável que pode ser utilziada no método
    public String boasVindasComVariavel(@PathVariable String nome) {
        return "Seja bem vindo(a) " + nome;
    }

    @PostMapping("/pessoa") // Annotation utilizada para criar uma rota com suporte a requisição post
    public Pessoa pessoa(@RequestBody Pessoa p) { // Annotation responsável por obter dados vindos de outras APIs ou do
                                                  // front-end, sua estrutura geralmente é um JSON com as
                                                  // características do modelo
        return p;
    }

}

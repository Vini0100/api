package com.projeto.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.projeto.api.Repository.Repositorio;
import com.projeto.api.model.Mensagem;
import com.projeto.api.model.Pessoa;

@Service // Falará para o Spring que isto é uma Service
public class Servico {

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repositorio acao;

    // Valida se os dados passados pelo POST através de uma JSON estão corretos
    public ResponseEntity<?> cadastrar(Pessoa obj) {
        if (obj.getNome().equals("")) {
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (obj.getIdade() < 0) {
            mensagem.setMensagem("Informe uma idade valida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

    // Selecionar pessoas
    public ResponseEntity<?> selecionar() {
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }

    // Selecionar Pessoas através do código
    public ResponseEntity<?> selecionarPeloCodigo(int codigo) {
        if (acao.countByCodigo(codigo) == 0) {// Se a contagem de pessoas com o código passado for == 0, estão é uma
                                              // BAD_REQUEST
            mensagem.setMensagem("Não foi encontrada nenhuma pessoa.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acao.findByCodigo(codigo), HttpStatus.OK);
        }
    }

    // Editar dados
    public ResponseEntity<?> editar(Pessoa obj) {
        if (acao.countByCodigo(obj.getCodigo()) == 0) {// Caso o código da pessoa informada não exista
            mensagem.setMensagem("O código informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        } else if (obj.getNome().equals("")) {
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (obj.getIdade() < 0) {
            mensagem.setMensagem("Informe uma idade valida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);// O Save tem duas funções: Cadastrar(Quando
                                                                       // passamos um obj sem o ID, o Sprig
            // entende que será cadastrado um novo obj) e Editar
        }
    }

    // Remover registros
    public ResponseEntity<?> remover(int codigo) {
        if (acao.countByCodigo(codigo) == 0) {
            mensagem.setMensagem("O código informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        } else {
            Pessoa obj = acao.findByCodigo(codigo);
            acao.delete(obj); // Precisa passar o obj completa para fazer o delete

            mensagem.setMensagem("Pessoa deletada com sucesso.");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
}

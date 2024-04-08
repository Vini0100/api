package com.projeto.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "clientes") // Por padrao e o nome da classe, mas pode ser alterada
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Chave primária
    private int codigo;

    // É preciso da classe Validação tbm
    @NotEmpty(message = "Informe um nome") // Caso eu tente passar um arquivo JSON com "nome" VAZIO, dará erro e
                                           // apresentará esta mensagem
    private String nome;

    @Email(message = "Informe um e-mail válido") // Caso eu tente passar um arquivo JSON isto Validará se o email tem
                                                 // "@" e ".", caso não, retorna a mensagem.
    private String email;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

package com.example.demo;

import java.util.List;

public class Game {
    //Criando variaveis, construtor, getters e setters
    private String id;
    private String nome;
    private int quantidade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Game(String id, String nome, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    //Construtor vazio
    public Game() {
    }

    //Buscar jogo por ID
    public static Game findById(List<Game> games, String id) {
        for (Game game : games) {
            if (game.getId().equals(id)) {
                return game;
            }
        }
        return null; // Retorna null se o jogo não for encontrado
    }

    // Atualize os campos relevantes do jogo com base no jogo atualizado
    public void updatedGame(Game updatedGame) {
        if(updatedGame.getNome() != null) {
            this.nome = updatedGame.getNome();
        }
        if(updatedGame.getQuantidade() >= 0) {
            this.quantidade = updatedGame.getQuantidade();
        }
    }
}

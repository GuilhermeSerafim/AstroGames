package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api-travels/travels")
public class TravelController {
    private List<Game> games = new ArrayList<>(); //Lista de todos os games
    @GetMapping //Será chamado quando uma solicitação HTTP GET
    public ResponseEntity<List<Game>> find() { //É a assinatura do método find(), que indica o tipo de retorno que esse método deve produzir.
        //Ele retorna um objeto ResponseEntity que encapsula uma lista de objetos do tipo Game
        // Isso significa que a resposta HTTP será no formato JSON e conterá uma lista de jogos.
        return ResponseEntity.ok(Arrays.asList(
                new Game("1", "Fortnite", 2),
                new Game("2", "League Of Legends", 103),
                new Game("3", "Among Us,", 22),
                new Game("4", "GTA V", 7)));
    }

    //CRUD

    //Criar
    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        games.add(game);
        return ResponseEntity.ok(game);
    }

    //Recuperar todos os jogos - Tá dando alguma coisa errada aqui, retorna o array vazio
    @GetMapping("/find")
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.ok(games);
    }

    //Recuperar jogo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable String id) {
        Game game = Game.findById(games, id);
        if(game != null) {
            return ResponseEntity.ok(game);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Atualizar um jogo existente com base no ID
    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable String id, @RequestBody Game updatedGame) {
        Game game = Game.findById(games, id);

        if(game != null) {
            game.updatedGame(updatedGame);
            return ResponseEntity.ok(game);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

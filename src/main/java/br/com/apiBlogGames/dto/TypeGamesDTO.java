package br.com.apiBlogGames.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeGamesDTO {
    private Long idGame;

    private String gameCategory;

    public TypeGamesDTO(){
        this.gameCategory = gameCategory;
    }
}



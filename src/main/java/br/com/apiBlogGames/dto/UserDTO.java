package br.com.apiBlogGames.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDTO {
    private Long idUser;

    private String namePersonUser;

    private String nickNameUser;

    private String userEmail;

    private String userPassword;

    private String typeGames;

    public UserDTO(){
        this.namePersonUser = namePersonUser;
        this.nickNameUser = nickNameUser;
        this.userPassword = userPassword;
        this.typeGames = typeGames;
    }

}

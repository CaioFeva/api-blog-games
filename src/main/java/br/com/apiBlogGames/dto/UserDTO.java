package br.com.apiBlogGames.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long idUser;

    private String namePersonUser;

    private String nickNameUser;

    private String userPassword;

    private String typeGames;

    private String userEmail;

    public UserDTO(){
        this.namePersonUser = namePersonUser;
        this.nickNameUser = nickNameUser;
        this.userPassword = userPassword;
        this.typeGames = typeGames;
        this.userEmail = userEmail;
    }

}

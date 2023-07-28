package br.com.apiBlogGames.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PerfilUserDTO {

    private Long idPerfil;

    private String nickNameUser;

    private String dateCreate;

    private String description;

    private String following;

    private String followers;

    public PerfilUserDTO(){
        this.idPerfil = idPerfil;
        this.nickNameUser = nickNameUser;
        this.dateCreate = dateCreate;
        this.description = description;
        this.following = following;
        this.followers = followers;
    }
}

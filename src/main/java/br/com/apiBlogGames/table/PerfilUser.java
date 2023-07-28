package br.com.apiBlogGames.table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PerfilUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil", nullable = false)
    private Long idPerfil;

    @Column(name = "nick_name_user", nullable = false)
    private String nickNameUser;

    @Column(name = "date_create", nullable = false)
    private String dateCreate;

    @Column(name = "description")
    private String description;

    @Column(name = "following")
    private String following;

    @Column(name = "followers")
    private String followers;

}

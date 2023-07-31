package br.com.apiBlogGames.table;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "users")
public class Users implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "name_person_user", nullable = false)
    private String namePersonUser;

    @Column(name = "nick_name_user", nullable = false)
    private String nickNameUser;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "type_games", nullable = false)
    private String typeGames;

    @Column(name = "email_user", nullable = false)
    private String userEmail;



}

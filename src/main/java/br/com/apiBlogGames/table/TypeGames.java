package br.com.apiBlogGames.table;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "type_games")
public class TypeGames {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game", nullable = false)
    private Long idGame;

    @Column(name = "game_category", nullable = false)
    private String gameCategory;

}

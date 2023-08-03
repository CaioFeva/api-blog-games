package br.com.apiBlogGames.repositories;

import br.com.apiBlogGames.table.TypeGames;
import br.com.apiBlogGames.table.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeGamesRepository extends JpaRepository<TypeGames, Long> {
    TypeGames findByGameCategory(String tipogames);
}

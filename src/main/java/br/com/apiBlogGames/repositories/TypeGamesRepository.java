package br.com.apiBlogGames.repositories;

import br.com.apiBlogGames.table.TypeGames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeGamesRepository extends JpaRepository<TypeGames, Long> {

}

package br.com.apiBlogGames.repositories;

import br.com.apiBlogGames.table.PerfilUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilUserRepository extends JpaRepository<PerfilUser, Long> {

    PerfilUser findByNickNameUser(String nickName);


}

package br.com.apiBlogGames.repositories;


import br.com.apiBlogGames.table.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByNickNameUser(String nickName);

    Users findByUserEmail(String email);
}

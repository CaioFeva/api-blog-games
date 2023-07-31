package br.com.apiBlogGames.service;




import br.com.apiBlogGames.dto.UserDTO;
import br.com.apiBlogGames.mapper.DozzerMapper;
import br.com.apiBlogGames.repositories.UsersRepository;
import br.com.apiBlogGames.table.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsersRepository usersRepository;

    public List<Users> findAll(){
        return usersRepository.findAll();
    }

    public UserDTO createUser(UserDTO user) throws Exception {

        Users nickName = null;

        if(user.getNickNameUser() != null && !user.getNickNameUser().isEmpty()){
            nickName = usersRepository.findByNickNameUser(user.getNickNameUser());
            if (nickName !=null ){
                throw new Exception("Já existe um usuário com esse nick");
            }
        }else{
            throw new Exception("NickName é igual a null");
        }


        var criarUsuario = DozzerMapper.parseObject(user, Users.class);
        System.out.println("criarUsuario"+ criarUsuario);

        UserDTO respUsuario = DozzerMapper.parseObject(usersRepository.save(criarUsuario), UserDTO.class);

        System.out.println("respUsuario"+ respUsuario);

        return respUsuario;
    }


}

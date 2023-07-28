package br.com.apiBlogGames.service;


import br.com.apiBlogGames.dto.PerfilUserDTO;
import br.com.apiBlogGames.dto.UserDTO;
import br.com.apiBlogGames.mapper.DozzerMapper;
import br.com.apiBlogGames.repositories.PerfilUserRepository;
import br.com.apiBlogGames.table.PerfilUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;


@Service
public class PerfilUserService {


    @Autowired
    PerfilUserRepository perfilUserRepository;



    public String createProfileWhenCreatingNewUser(UserDTO user) throws Exception {
        //Carrega Dados Básicos para perfil do usuário
        PerfilUserDTO perfil = new PerfilUserDTO();
        var resp = new PerfilUser();

        if(user.getNickNameUser() != null){
            var buscaUsuario = perfilUserRepository.findByNickNameUser(user.getNickNameUser());

            if(buscaUsuario != null){
                throw new Exception("Já existe um perfil com esse nickName");
            }
            else{
                perfil.setNickNameUser(user.getNickNameUser());
                perfil.setDateCreate(LocalDate.now().toString());
                perfil.setDescription("Fale algo sobre você ou deixe alguma curiosidade. :)");
                var createPerfil = DozzerMapper.parseObject(perfil, PerfilUser.class);
                resp = perfilUserRepository.save(createPerfil);
            }
        }else{
            return "NickName é obrigatório para criar um perfil.";
        }

        return resp.hashCode() == 200 ? "Pefil Criado" : "Erro ao criar perfil para o usuario"+ user.getNickNameUser();
    }



}

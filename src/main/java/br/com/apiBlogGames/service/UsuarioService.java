package br.com.apiBlogGames.service;


import br.com.apiBlogGames.dto.FormLoginDTO;
import br.com.apiBlogGames.dto.UserDTO;
import br.com.apiBlogGames.mapper.DozzerMapper;
import br.com.apiBlogGames.repositories.UsersRepository;
import br.com.apiBlogGames.security.SecurityLogin;
import br.com.apiBlogGames.table.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PerfilUserService perfilUserService;
    @Autowired
    SecurityLogin securityLogin;


    public List<Users> findAll(){
        return usersRepository.findAll();
    }

    public UserDTO createUser(UserDTO user) throws Exception {

        validationUser(user);

        var criarUsuario = DozzerMapper.parseObject(user, Users.class);

        UserDTO respUsuario = DozzerMapper.parseObject(usersRepository.save(criarUsuario), UserDTO.class);

        perfilUserService.createProfileWhenCreatingNewUser(respUsuario);

        return respUsuario;
    }

    private void validationUser(UserDTO user) throws Exception{

        Users nickName = null;

        if(user.getNickNameUser() != null || !user.getNickNameUser().isEmpty()){
            nickName = usersRepository.findByNickNameUser(user.getNickNameUser());
            if (nickName !=null ){
                throw new Exception("Já existe um usuário com esse nick");
            }
        }else{
            throw new Exception("NickName é igual a null");
        }

        if (user.getUserEmail() != null || !user.getUserEmail().isEmpty() ){
            nickName = usersRepository.findByUserEmail(user.getUserEmail());
            if (nickName !=null ){
                throw new Exception("Já existe uma conta registrada com esse email");
            }
        }else {
            throw new Exception("Email é um dado Obrigatório");
        }

    }

    public String login(FormLoginDTO user) throws Exception {

        Users nickName = usersRepository.findByUserEmail(user.getEmail());
        String token;
        if(nickName.getUserEmail().equals(user.getEmail()) && nickName.getUserPassword().equals(user.getPassword())){
            token = securityLogin.generateToken(nickName);
        }
        else {
            throw new Exception("Email ou senha incorretos.");
        }

        return token;
    }




}

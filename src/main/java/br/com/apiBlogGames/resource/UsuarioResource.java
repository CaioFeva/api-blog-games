package br.com.apiBlogGames.resource;


import br.com.apiBlogGames.dto.TypeGamesDTO;
import br.com.apiBlogGames.dto.UserDTO;
import br.com.apiBlogGames.service.TypeGamesService;
import br.com.apiBlogGames.table.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import br.com.apiBlogGames.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioResource {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    TypeGamesService typeGamesService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> findAll() throws Exception{
        return usuarioService.findAll();
    }

    @PostMapping(value ="/criarUsuario", produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO createUser(@RequestBody UserDTO user) throws Exception {

        return usuarioService.createUser(user);
    }

    @PostMapping(value ="/criarCategoria", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createCategory(@RequestBody TypeGamesDTO typegames) throws Exception {
        return typeGamesService.createCategory(typegames);
    }



}

package br.com.apiBlogGames.resource;


import br.com.apiBlogGames.dto.FormLoginDTO;
import br.com.apiBlogGames.dto.UserDTO;
import br.com.apiBlogGames.table.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import br.com.apiBlogGames.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioResource {

    @Autowired
    UsuarioService service;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> findAll() throws Exception{
        return service.findAll();
    }

    @PostMapping(value ="/criarUsuario", produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDTO user) throws Exception {

         service.createUser(user);

    }

    @PostMapping(value ="/login", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody FormLoginDTO user) throws Exception {
        return service.login(user);
    }

}

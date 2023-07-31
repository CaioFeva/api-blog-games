package br.com.apiBlogGames.service;

import br.com.apiBlogGames.dto.TypeGamesDTO;
import br.com.apiBlogGames.dto.UserDTO;
import br.com.apiBlogGames.mapper.DozzerMapper;
import br.com.apiBlogGames.repositories.TypeGamesRepository;
import br.com.apiBlogGames.table.TypeGames;
import br.com.apiBlogGames.table.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeGamesService {
    @Autowired
    TypeGamesRepository typeGamesRepository;
    public String createCategory(TypeGamesDTO createcategory) throws Exception{


        var createType = DozzerMapper.parseObject(createcategory, TypeGames.class);
        System.out.println("criarUsuario"+ createType);

        TypeGamesDTO respUsuario = DozzerMapper.parseObject(typeGamesRepository.save(createType), TypeGamesDTO.class);
        System.out.println(respUsuario);


        return respUsuario.getGameCategory();
    }
}

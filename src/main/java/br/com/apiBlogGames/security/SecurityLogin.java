package br.com.apiBlogGames.security;

import br.com.apiBlogGames.table.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@Component
public class SecurityLogin {


    private static final String SECRET_KEY = "Kz$vQr&9Bx#g*U5@";
    private long EXPIRATION_TOKEN = 28800000;

    public String generateToken(Users dadosUsuario){
        Date agora = new Date();
        Date expiration = new Date(agora.getTime() + EXPIRATION_TOKEN);

        String jwt = Jwts.builder()
                .setIssuer("Stormpath")
                .setSubject("msilverman")
                .claim("name", "Micah Silverman")
                .claim("scope", "admins")
                // Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
                .setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
                // Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
                .setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();



         /*
         * .setSubject(dadosUsuario.getUserEmail())
                .claim("nickname", dadosUsuario.getNickNameUser())
                .setIssuedAt(agora)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
         *
         *
         * */

        return jwt;
    }



}

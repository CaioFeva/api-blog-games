package br.com.apiBlogGames.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class FormLoginDTO {
    String email;
    String password;
}

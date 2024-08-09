package com.soulscript.soul_script_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtDto {
    private String token;

    public JwtDto(String token) {
        this.token = token;
    }

}

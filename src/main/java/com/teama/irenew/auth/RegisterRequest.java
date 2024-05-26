package com.teama.irenew.auth;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class RegisterRequest {


    private String name;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

}

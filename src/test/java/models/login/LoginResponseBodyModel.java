package models.login;

import lombok.Data;

@Data
public class LoginResponseBodyModel {
    private String userId;
    private String username;
    private String password;
    private String token;
    private String expires;
    private String created_date;
    private String isActive;
}

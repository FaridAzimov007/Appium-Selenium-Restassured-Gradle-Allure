package rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginData {
    private String email;
    private String password;
}

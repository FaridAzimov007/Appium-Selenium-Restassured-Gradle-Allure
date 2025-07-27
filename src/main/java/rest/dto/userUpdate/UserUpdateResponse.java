package rest.dto.userUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserUpdateResponse {
    private String name;
    private String job;
    private String updatedAt;
}

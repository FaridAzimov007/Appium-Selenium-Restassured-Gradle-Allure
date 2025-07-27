package rest.dto.userInfo.singleUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleUserResponse {
    private SingleUserData data;
    private Support support;
}

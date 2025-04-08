package txn.dto;

import lombok.Data;
import txn.model.UserRoleEnum;

@Data
public class UserResponseDTO {

    private Integer id;
    private String username;
    private String password;
    private UserRoleEnum userRole;

}

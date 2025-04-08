package txn.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import txn.model.UserRoleEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserDataDTO {

    @NotNull(message = "username.required")
    @Size(min = 3, message = "Username must be at least 3 characters long")
    private String username;

    @NotNull(message = "password.required")
    @Size(min = 4, message = "Password must be at least 4 characters long")
    private String password;
    UserRoleEnum userRole;

}

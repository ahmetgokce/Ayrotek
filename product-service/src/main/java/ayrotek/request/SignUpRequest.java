package ayrotek.request;

import ayrotek.entity.AppUserRole;
import lombok.Data;

import java.util.List;

@Data
public class SignUpRequest {
    private String username;
    private String password;
    List<AppUserRole> appUserRoles;
}

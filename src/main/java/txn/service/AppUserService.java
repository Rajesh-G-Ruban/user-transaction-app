package txn.service;

import txn.dto.CommonResponse;
import txn.dto.TokenResponse;
import txn.model.AppUser;

import javax.servlet.http.HttpServletRequest;

public interface AppUserService {
    TokenResponse sigIn(String username, String password);

    CommonResponse signupUser(String username, String password);

    void signupUser(AppUser user);

    AppUser whoAmi(HttpServletRequest req);

    String refresh(String username);
}

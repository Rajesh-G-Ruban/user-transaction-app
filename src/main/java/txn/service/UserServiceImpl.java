package txn.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import txn.dto.CommonResponse;
import txn.dto.TokenResponse;
import txn.model.AppUser;
import txn.model.UserRoleEnum;
import txn.repository.UserRepository;
import txn.security.JwtTokenProvider;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements AppUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public TokenResponse sigIn(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            String token = jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getUserRole());
            return new TokenResponse(token, HttpStatus.CREATED.value(), "success");
        } catch (AuthenticationException e) {
            logger.info("Invalid username/password supplied : {}", HttpStatus.UNAUTHORIZED);
            return new TokenResponse("", HttpStatus.UNAUTHORIZED.value(), "Failed");
        }
    }

    @Override
    public CommonResponse signupUser(String username, String password) {

        if (!userRepository.existsByUsername(username)) {

            AppUser appUser = new AppUser();
            appUser.setUsername(username);
            appUser.setUserRole(UserRoleEnum.ROLE_CLIENT);
            appUser.setPassword(passwordEncoder.encode(password));
            AppUser user = userRepository.save(appUser);

            return new CommonResponse(HttpStatus.CREATED.value(), "user.created.id." + user.getId());
        }
        return new CommonResponse(HttpStatus.CONFLICT.value(), "username.exist");
    }


    //this method only created for admin only from the application build
    @Override
    public void signupUser(AppUser appUser) {
        if (!userRepository.existsByUsername(appUser.getUsername())) {
            appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
            userRepository.save(appUser);
        }
    }

    @Override
    public AppUser whoAmi(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    @Override
    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getUserRole());
    }

}

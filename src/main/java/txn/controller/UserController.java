package txn.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import txn.dto.CommonResponse;
import txn.dto.TokenResponse;
import txn.dto.UserDataDTO;
import txn.dto.UserResponseDTO;
import txn.security.JwtBlacklistService;
import txn.service.AppUserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/txn-app/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    JwtBlacklistService blacklistToken;


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/sign-in")
    public TokenResponse login(@RequestBody @Valid UserDataDTO dto, BindingResult result) {
        logger.info("Received api:login");
        return appUserService.sigIn(dto.getUsername(), dto.getPassword());
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/signup")
    public CommonResponse signup(@RequestBody @Valid UserDataDTO user, BindingResult result) {
        logger.info("Received api:create user");

        if (result.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();
            result.getAllErrors().forEach(error -> {
                errorMessages.append(error.getDefaultMessage());
            });
            return new TokenResponse("",HttpStatus.BAD_REQUEST.value(), errorMessages.toString());
        }
        return appUserService.signupUser(user.getUsername(), user.getPassword());
    }



    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/sign-out")
    public CommonResponse signOut(HttpServletRequest request) {

        logger.info("Received api:log.out");

        String jwtToken = extractJwtFromRequest(request);
        if (jwtToken != null) {
            blacklistToken.blacklistToken(jwtToken);
        }
        return new CommonResponse(HttpStatus.CREATED.value(), "logged.out");
    }

    @GetMapping(value = "/me")
    public UserResponseDTO whoAmi(HttpServletRequest req) {
        logger.info("Received.api : who is current user");
        return modelMapper.map(appUserService.whoAmi(req), UserResponseDTO.class);
    }


    private String extractJwtFromRequest(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }

}

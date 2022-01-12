package ayrotek.service;

import ayrotek.entity.AppUser;
import ayrotek.repository.UserRepository;
import ayrotek.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username,userRepository.findByUsername(username).getAppUserRoles());
        } catch (AuthenticationException e) {
            return "Invalid username/password supplied";
        }
    }

    public String signup(String username, String password) {
        try {
            AppUser appUser = new AppUser();
            appUser.setUsername(username);
            appUser.setPassword(passwordEncoder.encode(password));
            userRepository.save(appUser);
            return "success";
        }catch (Exception e) {
            return e.getMessage();
        }

    }

    public String delete(String username) {
        try {
            userRepository.deleteByUsername(username);
            return username + "deleted";
        } catch (Exception e) {
           return "failed";
        }

    }

}

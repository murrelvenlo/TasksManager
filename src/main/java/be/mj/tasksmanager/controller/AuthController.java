package be.mj.tasksmanager.controller;

import be.mj.tasksmanager.dto.AuthenticationRequest;
import be.mj.tasksmanager.dto.AuthenticationResponse;
import be.mj.tasksmanager.dto.SignupRequest;
import be.mj.tasksmanager.dto.UserDto;
import be.mj.tasksmanager.service.AuthService;
import be.mj.tasksmanager.service.jwt.UserDetailsServiceImpl;
import be.mj.tasksmanager.util.JwtUtil;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class AuthController
{
    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody SignupRequest signupRequest)
    {
        UserDto createdUser = authService.createUser(signupRequest);
        if (createdUser == null)
            return new ResponseEntity<>("User is not created", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/auth")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest,
    HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException,
            IOException, java.io.IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException exc)
        {
            throw new BadCredentialsException("Incorrect Username or password!");
        } catch (DisabledException disabledException)
        {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User does not exists. Register user first!");
            return null;
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        return new AuthenticationResponse(jwt);
    }
}

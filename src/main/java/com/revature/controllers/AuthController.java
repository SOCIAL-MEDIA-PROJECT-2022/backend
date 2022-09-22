package com.revature.controllers;

import com.revature.dtos.LoginRequest;
import com.revature.dtos.RegisterRequest;
import com.revature.models.Profile;
import com.revature.models.User;
import com.revature.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AuthController {
	
	private static final Logger logger = Logger.getLogger(AuthController.class.getName());
	private static final Level logLevel = Level.INFO;
	

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
    	logger.log(logLevel,loginRequest.toString());
    	
        Optional<User> optional = authService.findByCredentials(loginRequest.getEmail(), loginRequest.getPassword());

        if(!optional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        session.setAttribute("user", optional.get());
        
     

        return ResponseEntity.ok(optional.get());
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        session.removeAttribute("user");

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest registerRequest) {
        logger.log(logLevel, "Got here with: ");
        logger.log(logLevel, registerRequest.toString());
        User created = new User(0,
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                registerRequest.getFirstName(),
                registerRequest.getLastName()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(created));
    }
}

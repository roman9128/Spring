package rt.hw7;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello! You are watching a common page");
    }

    @GetMapping("/user")
    public ResponseEntity<String> helloUser(Authentication authentication) {
        return ResponseEntity.ok("Hello, " + authentication.getName());
    }

    @GetMapping("/admin")
    public ResponseEntity<String> helloAdmin(Authentication authentication) {
        return ResponseEntity.ok("Hello, " + authentication.getName());
    }
}
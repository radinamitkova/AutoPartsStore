package bg.startit.autoPartsStore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class LoginController {

    @GetMapping("/login")
    public ResponseEntity<?> login()
    {
        return ResponseEntity.ok("Successfully login!");
    }

}

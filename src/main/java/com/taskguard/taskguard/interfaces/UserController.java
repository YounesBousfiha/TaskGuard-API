package com.taskguard.taskguard.interfaces;

import com.taskguard.taskguard.domain.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/user")
public class UserController {

    @GetMapping("/{id}")
    public User getUserProfile(@PathVariable Long id) {
        // Implement user retrieval logic
        return null;
    }

    @PutMapping("/{id}")
    public User updateUserProfile(@PathVariable Long id, @RequestBody User user) {
        // Implement user update logic
        return null;
    }


}

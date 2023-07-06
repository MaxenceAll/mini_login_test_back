package com.alibou.security.admin;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @GetMapping
    public String get() {
        return "Admin only :: Hello Admin from get method";
    }
    @PostMapping
    public String post() {
        return "Admin only :: Hello Admin from post method";
    }
    @PutMapping
    public String put() {
        return "Admin only :: Hello Admin from put method";
    }
    @DeleteMapping
    public String delete() {
        return "Admin only :: Hello Admin from delete method";
    }
    @PatchMapping
    public String patch() {
        return "Admin only :: Hello Admin from patch method";
    }

}

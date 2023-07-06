package com.alibou.security.manager;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manager")
public class ManagerController {

    @GetMapping
    public String get() {
        return "Manager only :: Hello Manager from get method";
    }
    @PostMapping
    public String post() {
        return "Manager only :: Hello Manager from post method";
    }
    @PutMapping
    public String put() {
        return "Manager only :: Hello Manager from put method";
    }
    @DeleteMapping
    public String delete() {
        return "Manager only :: Hello Manager from delete method";
    }
    @PatchMapping
    public String patch() {
        return "Manager only :: Hello Manager from patch method";
    }
}

package ru.netology.hibernateorm.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class MyNewController {
    @GetMapping("/my-account")
    @PreAuthorize("@validationService.isValid(#username)")
    public String myAccount(String username) {
        return "Welcome " + username;
    }

    @GetMapping("/account")
    @Secured("ROLE_READ")
    private String hello() {
        return "Hello from user account!";
    }


    @GetMapping("/account-edit")
    @RolesAllowed("ROLE_WRITE")
    private String edit() {
        return "Welcome to account options!";
    }


    @GetMapping("/database")
    @PreAuthorize("hasRole('WRITE') or hasRole('DELETE')")
    private String dataAccess() {
        return "Welcome to database!";
    }
}

package ru.netology.hibernateorm.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ValidationService {
    public boolean isValid(String username){
        return Objects.equals(username, SecurityContextHolder.getContext().getAuthentication().getName());
    }
}

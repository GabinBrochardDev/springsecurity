package com.gab.sprintsecurity.controllers;

import com.gab.sprintsecurity.entities.AppUser;
import com.gab.sprintsecurity.entities.RegisterDto;
import com.gab.sprintsecurity.repositories.AppUserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class AccountController {

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute(registerDto);
        model.addAttribute("success", false);
        return "register";
    }

    @PostMapping("/register")
    public String register(
            Model model,
            @Valid @ModelAttribute RegisterDto registerDto,
            BindingResult result) {

        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            result.addError(
                    new FieldError("registerDto", "confirmationPassword",
                            "Password and Confirm Password do not match")
            );
        }

        AppUser appUser = appUserRepository.findByUsername(registerDto.getUsername());
        if (appUser != null) {
            result.addError(
                    new FieldError("registerDto", "username",
                            "Username is already in use")
            );
        }

        if (result.hasErrors()) {
            return "register";
        }

        try {
            // Création d'un nouveau compte utilisateur
            var bCryptEncoder = new BCryptPasswordEncoder();

            AppUser newAppUser = new AppUser();

            newAppUser.setUsername(registerDto.getUsername());
            newAppUser.setPassword(bCryptEncoder.encode(registerDto.getPassword()));
            newAppUser.setPrenom(registerDto.getPrenom());
            newAppUser.setNom(registerDto.getNom());

            newAppUser.setRole("USER");
            newAppUser.setDateCreation(new Date());

            appUserRepository.save(newAppUser);

            model.addAttribute("registerDto", new RegisterDto());
            model.addAttribute("success", true);
        }
        catch (Exception ex) {
            result.addError(
                    new FieldError("registerDto", "prenom",
                            ex.getMessage())
            );
        }

        return "register";
    }

}


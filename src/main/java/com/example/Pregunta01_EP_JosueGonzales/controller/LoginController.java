package com.example.Pregunta01_EP_JosueGonzales.controller;

import com.example.Pregunta01_EP_JosueGonzales.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/formulario")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User()); // Objeto vacío para el formulario
        return "login"; // Nombre del template de login
    }

    @PostMapping("/login")
    public String processLogin(User user) {
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            return "redirect:/success"; // Redirige a la pantalla de éxito
        } else {
            return "redirect:/error"; // Redirige a la pantalla de error
        }
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success"; // Pantalla de éxito
    }

    @GetMapping("/error")
    public String showErrorPage() {
        return "error"; // Pantalla de error
    }
}

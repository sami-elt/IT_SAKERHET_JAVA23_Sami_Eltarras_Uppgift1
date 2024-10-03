package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class KundController {

    @Autowired
    private KundService kundService;

    private BCryptPasswordEncoder passHash = new BCryptPasswordEncoder();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/skapa")
    public String sparaKund(Kund kund, Model model) {

        kund.setPassword(passHash.encode(kund.getPassword()));

        kundService.save(kund);
        model.addAttribute("message", "ny kund registrerad");
        return "redirect:/";
    }

    @GetMapping("/skapa")
    public String skapa(Model model) {

        model.addAttribute("kund", new Kund());
        return "skapa";
    }

    @GetMapping("/kund/search")
    public String searchKund(@RequestParam("firstname") String firstname, Model model) {

        List<Kund> kunder = kundService.findByFirstName(firstname);

        model.addAttribute("kunder", kunder);

        return "name";
    }

    @GetMapping("/deleteKund/{id}")
    public String deleteKund(@PathVariable long id) {
        kundService.deleteById(id);
        return "redirect:/";
    }
}

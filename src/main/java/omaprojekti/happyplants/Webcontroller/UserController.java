package omaprojekti.happyplants.Webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import omaprojekti.happyplants.Domain.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /* Listaa kaikki käyttäjät */
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }
}
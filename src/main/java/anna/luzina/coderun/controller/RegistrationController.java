package anna.luzina.coderun.controller;

import anna.luzina.coderun.model.User;
import anna.luzina.coderun.repository.UserRepo;
import anna.luzina.coderun.service.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(Model model){
        return "registration";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @PostMapping("/registration")
    public String registerUser(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {

        User usr = userRepo.findByUsername(username);


        if(usr!=null){
            model.addAttribute("message", "User already exists");
            return "redirect:/registration";
        }
        User newUsr = new User();
        newUsr.setPassword(password);
        newUsr.setUsername(username);
        userService.saveUser(newUsr);
        model.addAttribute("message", "User registered successfully!");

        return "redirect:/login";
    }
}
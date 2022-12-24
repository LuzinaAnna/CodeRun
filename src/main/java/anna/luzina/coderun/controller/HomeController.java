package anna.luzina.coderun.controller;

import anna.luzina.coderun.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    TaskRepo taskRepo;
    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("tasks", taskRepo.findAll());
        return "home";
    }
}

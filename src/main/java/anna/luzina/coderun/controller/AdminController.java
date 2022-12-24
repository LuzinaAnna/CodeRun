package anna.luzina.coderun.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminPanel")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminController {
    @GetMapping()
    String panel(Model model){
        return "adminPanel";
    }
    @PostMapping("/createTask")
    String createTask(){
        return "adminPanel";
    }
}

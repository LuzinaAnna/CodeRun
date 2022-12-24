package anna.luzina.coderun.controller;

import anna.luzina.coderun.domain.User;
import anna.luzina.coderun.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {
    @Autowired
    UserRepo userRepo;

    //TODO:Удали эту хуйню, есть sec:authentication="name"
    @ModelAttribute("currentUser")
    public User currentUser() {
        return userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}

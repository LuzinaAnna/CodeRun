package anna.luzina.coderun.controller;


import anna.luzina.coderun.domain.Task;
import anna.luzina.coderun.repository.TaskRepo;
import anna.luzina.coderun.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller()
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskRepo taskRepo;

    @Autowired
    UserRepo userRepo;
    @GetMapping("{id}")
    public String getSolveTaskPage(@PathVariable("id") Long taskId, Model model) {
        Optional<Task> optionalTask = taskRepo.findById(taskId);
        if (optionalTask.isEmpty()) {
            return "redirect:/error";
        }
        model.addAttribute("task", optionalTask.get());
        return "solve_page";
    }

    private boolean isCorrectSolve(Long taskId, String solve) {
        return true; //TODO: need to be implemented by Andrey
    }

    @PostMapping("{id}")
    public String sendSolveTask(@PathVariable("id") Long taskId, @RequestParam("solve") String solve) {
        Optional<Task> optionalTask = taskRepo.findById(taskId);
        if (optionalTask.isEmpty()) {
            return "redirect:/error";
        }
        Task task = optionalTask.get();
        if (isCorrectSolve(taskId, solve)) {
            task.setNumberSolvedCorrectly(task.getNumberSolvedCorrectly() + 1);
        }
        task.setNumberSent(task.getNumberSent() + 1);
        taskRepo.save(task);
        userRepo.findByUsername(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName())
                .getSolvedTasks()
                .add(task);
        return "redirect:/";
    }
}

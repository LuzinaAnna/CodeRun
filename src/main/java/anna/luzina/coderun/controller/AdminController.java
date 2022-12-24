package anna.luzina.coderun.controller;

import anna.luzina.coderun.domain.Tag;
import anna.luzina.coderun.domain.Task;
import anna.luzina.coderun.repository.TagRepo;
import anna.luzina.coderun.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/adminPanel")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminController {
    @Autowired
    TaskRepo taskRepo;

    @Autowired
    TagRepo tagRepo;

    @GetMapping()
    String panel(Model model){
        return "adminPanel";
    }
    @GetMapping("/createTask")
    String createTask(){
        return "createTask";
    }
    @PostMapping("/createTask")
    String createTaskPost(@RequestParam("title") String title,@RequestParam("description") String description, @RequestParam("tag") String tag, Model model){
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        Tag tag1= new Tag();
        tag1.setName(tag);
        tagRepo.save(tag1);
        Set<Tag> tagss = new HashSet<>();
        tagss.add(tag1);
        task.setTags(tagss);
        task.setNumberSent(0);
        task.setNumberSolvedCorrectly(0);
        taskRepo.save(task);
        return "redirect:/adminPanel";
    }
}

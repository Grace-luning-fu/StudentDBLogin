package me.grace.studentdb;

import me.grace.studentdb.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    StudentRepo studentRepo;

    @RequestMapping("/")
    public String listContact(Model model)
    {
        return "welcome";
    }

    @RequestMapping("/login")
    public String logon(){
        return"login";
    }

    @GetMapping("/add")
    public String studentForm(Model model){
        model.addAttribute("student", new Student());
        return "studentform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Student student, BindingResult bresult){
        if (bresult.hasErrors()){
            return "studentform";
        }

        studentRepo.save(student);
        return "result";
    }

    @GetMapping("/displayall")
    public String showall(Model model) {

        model.addAttribute("allstudent", studentRepo.findAll());
        return "list";
    }
}

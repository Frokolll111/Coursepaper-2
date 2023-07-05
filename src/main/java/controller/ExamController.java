package controller;

import org.springframework.web.bind.annotation.*;
import service.ExaminerService;
import service.Question;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/{amount}")
    public Collection<Question> randomQuestion(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}

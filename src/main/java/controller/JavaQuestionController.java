package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.Question;
import service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question add(@RequestParam(required = false, value = "question") String question,
                        @RequestParam(required = false, value = "answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(@RequestParam(required = false, value = "question") String question,
                           @RequestParam(required = false, value = "answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping(path = "/java")
    public Collection<Question> All() {
        return questionService.getAll();
    }
}

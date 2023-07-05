package service;

import exception.ExceedingTheNumberOfQuestions;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getAll().size();
        if (size < amount|| amount<=0) {
            throw new ExceedingTheNumberOfQuestions("Превышено количество вопросов");
        }
        Set<Question> randomSet = new HashSet<>();
        while (randomSet.size() < amount) {
            randomSet.add(questionService.getRandomQuestion());
        }
        return randomSet;
    }
}

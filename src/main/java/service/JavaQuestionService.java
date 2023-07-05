package service;

import exception.NotFindException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Random random = new Random();
    Set<Question> questionsSet = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        questionsSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questionsSet.contains(question)) {
            questionsSet.remove(question);
            return question;
        }
        throw new NotFindException("Такого вопроса нету");
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(questionsSet);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> randomQuestion = new ArrayList<>(questionsSet);
        int number = random.nextInt(getAll().size());
        return randomQuestion.get(number);
    }
}

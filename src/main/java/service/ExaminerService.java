package service;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}

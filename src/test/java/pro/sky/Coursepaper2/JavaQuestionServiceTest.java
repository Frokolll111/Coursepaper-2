package pro.sky.Coursepaper2;

import exception.NotFindException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.JavaQuestionService;
import service.Question;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @BeforeEach
    public void List() {
        javaQuestionService.add("Вопрос 1", "Ответ 1");
        javaQuestionService.add("Вопрос 2", "Ответ 2");
        javaQuestionService.add("Вопрос 3", "Ответ 3");
        javaQuestionService.add("Вопрос 4", "Ответ 4");
    }

    @Test
    public void add() {
        Question expected = new Question("Вопрос 5", "Ответ 5");
        assertEquals(expected,javaQuestionService.add("Вопрос 5", "Ответ 5"));
    }

    @Test
    public void remove() {
        Question expected = new Question("Вопрос 4", "Ответ 4");
        Question actual = javaQuestionService.remove(new Question("Вопрос 4", "Ответ 4"));
        assertEquals(expected, actual);
    }

    @Test
    public void removeException() {
        assertThrows(NotFindException.class, () -> javaQuestionService.remove(new Question("Вопрос 6", "Ответ 6")));
    }

    @Test
    public void getAll() {
        List<Question> expected = Arrays.asList(
                new Question("Вопрос 1", "Ответ 1"),
                new Question("Вопрос 2", "Ответ 2"),
                new Question("Вопрос 3", "Ответ 3"),
                new Question("Вопрос 4", "Ответ 4")
        );
        assertEquals(expected, javaQuestionService.getAll());
    }
}

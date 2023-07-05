package pro.sky.Coursepaper2;
import exception.ExceedingTheNumberOfQuestions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.ExaminerServiceImpl;
import service.Question;
import service.QuestionService;

import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl examinerServiceImpl;
    private Set<Question> questionSet;

    private final Collection<Question> questionCollection = Set.of(
            new Question("Вопрос 10", "Ответ 10"),
            new Question("Вопрос 11", "Ответ 11"),
            new Question("Вопрос 12", "Ответ 12"),
            new Question("Вопрос 13", "Ответ 13"),
            new Question("Вопрос 14", "Ответ 14")
    );

    @Test
    public void getANegativeAnswerToTheQuestion() {
        when(questionService.getAll()).thenReturn(questionCollection);
        assertThatExceptionOfType(ExceedingTheNumberOfQuestions.class).isThrownBy(() -> examinerServiceImpl.getQuestions(-1));
        assertThatExceptionOfType(ExceedingTheNumberOfQuestions.class).isThrownBy(() -> examinerServiceImpl.getQuestions(questionCollection.size() + 1));
    }

    @Test
    public void getAPositiveAnswerToTheQuestion() {
        when(questionService.getAll()).thenReturn(questionCollection);
        when(questionService.getRandomQuestion()).thenReturn(
                new Question("Вопрос 10", "Ответ 10"),
                new Question("Вопрос 10", "Ответ 10"),
                new Question("Вопрос 12", "Ответ 12"),
                new Question("Вопрос 13", "Ответ 13")
        );
        assertThat(examinerServiceImpl.getQuestions(3))
                .hasSize(3)
                .containsExactlyInAnyOrder(new Question("Вопрос 10", "Ответ 10"),
                        new Question("Вопрос 12", "Ответ 12"),
                        new Question("Вопрос 13", "Ответ 13")
                );

    }
}

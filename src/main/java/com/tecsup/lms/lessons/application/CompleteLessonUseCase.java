package com.tecsup.lms.lessons.application;

import com.tecsup.lms.lessons.domain.event.LessonCompletedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CompleteLessonUseCase {

    private final ApplicationEventPublisher eventPublisher;

    public CompleteLessonUseCase(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void completeLesson(String studentId, String lessonId, String courseId) {
        // Aquí iría la lógica real para marcar la lección como completada en la base de datos

        // Disparar el evento
        LessonCompletedEvent event = new LessonCompletedEvent(studentId, lessonId, courseId);
        eventPublisher.publishEvent(event);
    }
}


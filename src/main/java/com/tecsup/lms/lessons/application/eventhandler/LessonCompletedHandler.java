package com.tecsup.lms.lessons.application.eventhandler;

import com.tecsup.lms.lessons.domain.event.LessonCompletedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LessonCompletedHandler {

    @EventListener
    public void updateProgress(LessonCompletedEvent event) {
        log.info("📈 Actualizando progreso de estudiante {} en curso {}", event.getStudentId(), event.getCourseId());
    }

    @EventListener
    public void sendAchievementNotification(LessonCompletedEvent event) {
        log.info("🏆 Enviando notificación de logro por completar lección {} a estudiante {}", event.getLessonId(), event.getStudentId());
    }

    @EventListener
    public void checkCourseCompletion(LessonCompletedEvent event) {
        log.info("🔍 Verificando si estudiante {} completó el curso {}", event.getStudentId(), event.getCourseId());
    }
}

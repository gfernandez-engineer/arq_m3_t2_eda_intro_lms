package com.tecsup.lms.students.application.eventhandler;


import com.tecsup.lms.students.domain.event.StudentEnrolledEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StudentEnrolledHandler {

    @EventListener
    public void sendWelcomeEmail(StudentEnrolledEvent event) {
        log.info("📧 Enviando email de bienvenida a estudiante {} en curso {}", event.getStudentId(), event.getCourseId());
    }

    @EventListener
    public void updateCourseStats(StudentEnrolledEvent event) {
        log.info("📊 Actualizando estadísticas del curso {} por inscripción de estudiante {}", event.getCourseId(), event.getStudentId());
    }

    @EventListener
    public void grantMaterialAccess(StudentEnrolledEvent event) {
        log.info("📚 Creando acceso al material para estudiante {} en curso {}", event.getStudentId(), event.getCourseId());
    }
}

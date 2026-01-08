package com.tecsup.lms.students.application;

import com.tecsup.lms.students.domain.event.StudentEnrolledEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EnrollStudentUseCase {
    private final ApplicationEventPublisher publisher;

    public EnrollStudentUseCase(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void enroll(String studentId, String courseId) {
        // lógica de inscripción
        publisher.publishEvent(new StudentEnrolledEvent(studentId, courseId));
    }
}


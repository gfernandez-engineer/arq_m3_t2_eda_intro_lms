package com.tecsup.lms.students.domain.event;

import com.tecsup.lms.shared.domain.event.DomainEvent;
import lombok.Getter;

@Getter
public class StudentEnrolledEvent extends DomainEvent {
    private final String studentId;
    private final String courseId;

    public StudentEnrolledEvent(String studentId, String courseId) {
        super();
        this.studentId = studentId;
        this.courseId = courseId;
    }
}

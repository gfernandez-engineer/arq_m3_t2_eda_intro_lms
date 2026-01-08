package com.tecsup.lms.lessons.domain.event;

import com.tecsup.lms.shared.domain.event.DomainEvent;
import lombok.Getter;

@Getter
public class LessonCompletedEvent extends DomainEvent {
    private final String studentId;
    private final String lessonId;
    private final String courseId;

    public LessonCompletedEvent(String studentId, String lessonId, String courseId) {
        super();
        this.studentId = studentId;
        this.lessonId = lessonId;
        this.courseId = courseId;
    }
}

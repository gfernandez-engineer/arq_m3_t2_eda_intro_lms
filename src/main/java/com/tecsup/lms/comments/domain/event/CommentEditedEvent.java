package com.tecsup.lms.comments.domain.event;

import com.tecsup.lms.shared.domain.event.DomainEvent;

public class CommentEditedEvent extends DomainEvent {
    private final String courseId;
    private final String studentId;
    private final String text;
    private final int rating;

    public CommentEditedEvent(String courseId, String studentId, String text, int rating) {
        super();
        this.courseId = courseId;
        this.studentId = studentId;
        this.text = text;
        this.rating = rating;
    }

    public String courseId() { return courseId; }
    public String studentId() { return studentId; }
    public String text() { return text; }
    public int rating() { return rating; }
}

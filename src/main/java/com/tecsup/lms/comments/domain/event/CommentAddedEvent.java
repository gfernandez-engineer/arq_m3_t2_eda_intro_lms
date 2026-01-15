package com.tecsup.lms.comments.domain.event;


import com.tecsup.lms.shared.domain.event.DomainEvent;

public class CommentAddedEvent extends DomainEvent {
    private final String courseId;
    private final String studentId;
    private final String text;
    private final int rating;

    public CommentAddedEvent(String courseId, String studentId, String text, int rating) {
        super(); // inicializa eventId, eventType, ocurredOn
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

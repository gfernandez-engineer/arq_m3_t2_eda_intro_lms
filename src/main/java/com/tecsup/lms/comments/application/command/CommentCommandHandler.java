package com.tecsup.lms.comments.application.command;

import com.tecsup.lms.comments.domain.model.CourseComment;
import com.tecsup.lms.comments.domain.event.*;
import com.tecsup.lms.shared.infrastructure.eventsourcing.EventStore;

public class CommentCommandHandler {
    private final EventStore eventStore;

    public CommentCommandHandler(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public void handleAddComment(String courseId, String studentId, String text, int rating) {
        CourseComment aggregate = load(courseId);
        CommentAddedEvent event = aggregate.addComment(studentId, text, rating);
        eventStore.save(courseId, event);
    }

    public void handleEditComment(String courseId, String studentId, String newText, int newRating) {
        CourseComment aggregate = load(courseId);
        CommentEditedEvent event = aggregate.editComment(studentId, newText, newRating);
        eventStore.save(courseId, event);
    }

    private CourseComment load(String courseId) {
        CourseComment aggregate = new CourseComment(courseId);
        eventStore.getEvents(courseId).forEach(aggregate::apply);
        return aggregate;
    }
}

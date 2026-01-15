package com.tecsup.lms.comments.domain.model;

import com.tecsup.lms.comments.domain.event.*;
import com.tecsup.lms.shared.domain.event.DomainEvent;
import java.util.*;


public class CourseComment {
    private final String courseId;
    private final Map<String, Comment> commentsByStudent = new HashMap<>();

    public CourseComment(String courseId) {
        this.courseId = courseId;
    }

    public CommentAddedEvent addComment(String studentId, String text, int rating) {
        Comment comment = new Comment(studentId, text, new Rating(rating));
        commentsByStudent.put(studentId, comment);
        return new CommentAddedEvent(courseId, studentId, text, rating);
    }

    public CommentEditedEvent editComment(String studentId, String newText, int newRating) {
        if (!commentsByStudent.containsKey(studentId)) {
            throw new IllegalStateException("Comment not found");
        }
        Comment updated = new Comment(studentId, newText, new Rating(newRating));
        commentsByStudent.put(studentId, updated);
        return new CommentEditedEvent(courseId, studentId, newText, newRating);
    }

    public void apply(DomainEvent event) {
        if (event instanceof CommentAddedEvent) {
            CommentAddedEvent e = (CommentAddedEvent) event;
            commentsByStudent.put(e.studentId(), new Comment(e.studentId(), e.text(), new Rating(e.rating())));
        } else if (event instanceof CommentEditedEvent) {
            CommentEditedEvent e = (CommentEditedEvent) event;
            commentsByStudent.put(e.studentId(), new Comment(e.studentId(), e.text(), new Rating(e.rating())));
        }
    }

    //  Getter público para usar en los tests
    public Map<String, Comment> getComments() {
        return commentsByStudent;
    }
}

package com.tecsup.lms.comments.infrastructure.web;


import com.tecsup.lms.comments.application.command.CommentCommandHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentCommandHandler handler;

    public CommentController(CommentCommandHandler handler) {
        this.handler = handler;
    }

    @PostMapping("/add")
    public String addComment(@RequestParam String courseId,
                             @RequestParam String studentId,
                             @RequestParam String text,
                             @RequestParam int rating) {
        handler.handleAddComment(courseId, studentId, text, rating);
        return "Comment added successfully!";
    }

    @PostMapping("/edit")
    public String editComment(@RequestParam String courseId,
                              @RequestParam String studentId,
                              @RequestParam String text,
                              @RequestParam int rating) {
        handler.handleEditComment(courseId, studentId, text, rating);
        return "Comment edited successfully!";
    }
}

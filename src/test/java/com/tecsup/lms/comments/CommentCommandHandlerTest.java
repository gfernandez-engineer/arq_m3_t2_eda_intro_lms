package com.tecsup.lms.comments;

import com.tecsup.lms.comments.application.command.CommentCommandHandler;
import com.tecsup.lms.comments.domain.model.CourseComment;
import com.tecsup.lms.shared.infrastructure.eventsourcing.MemoryEventStore;
import com.tecsup.lms.shared.domain.event.DomainEvent;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommentCommandHandlerTest {

    @Test
    void testAddAndEditComment() {
        // Publisher dummy para pruebas (no hace nada)
        ApplicationEventPublisher publisher = event -> {};
        MemoryEventStore eventStore = new MemoryEventStore(publisher);
        CommentCommandHandler handler = new CommentCommandHandler(eventStore);

        String courseId = "curso123";
        String studentId = "estudiante456";

        // Act: agregar comentario
        handler.handleAddComment(courseId, studentId, "Muy buen curso", 5);

        // Assert: se guarda un evento
        List<DomainEvent> eventsAfterAdd = eventStore.getEvents(courseId);
        assertEquals(1, eventsAfterAdd.size());
        assertEquals("CommentAddedEvent", eventsAfterAdd.get(0).getEventType());

        // Act: editar comentario
        handler.handleEditComment(courseId, studentId, "Excelente contenido", 4);

        // Assert: ahora hay dos eventos
        List<DomainEvent> eventsAfterEdit = eventStore.getEvents(courseId);
        assertEquals(2, eventsAfterEdit.size());
        assertEquals("CommentEditedEvent", eventsAfterEdit.get(1).getEventType());

        // Reconstrucción del agregado
        CourseComment aggregate = new CourseComment(courseId);
        eventsAfterEdit.forEach(aggregate::apply);

        // Validar que el comentario final es el editado
        assertEquals("Excelente contenido", aggregate.getComments().get(studentId).text());
        assertEquals(4, aggregate.getComments().get(studentId).rating().value());
    }
}

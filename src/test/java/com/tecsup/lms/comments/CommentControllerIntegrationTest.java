package com.tecsup.lms.comments;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommentControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testAddCommentEndpoint() {
        String url = "/comments/add?courseId=curso123&studentId=estudiante456&text=Buen+curso&rating=5";
        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class);

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().contains("Comment added successfully"));
    }

    @Test
    void testEditCommentEndpoint() {
        String url = "/comments/edit?courseId=curso123&studentId=estudiante456&text=Excelente+contenido&rating=4";
        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class);

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().contains("Comment edited successfully"));
    }
}

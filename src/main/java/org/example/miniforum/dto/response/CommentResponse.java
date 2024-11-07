package org.example.miniforum.dto.response;

import jakarta.persistence.Column;
import lombok.*;
import org.example.miniforum.model.User;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {
    private int id;
    private String content;
    private User user;
    private LocalDateTime createDate;

}

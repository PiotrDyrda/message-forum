package model;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Data
public class Message {

    private Long id;

    @NonNull
    private String content;

    private LocalDateTime timestamp = LocalDateTime.now();

}

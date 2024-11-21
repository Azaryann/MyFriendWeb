package am.azaryan.myfriendweb.model;

import java.util.Date;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private int id;

    private int senderId;

    private int receiverId;

    private String message;

    private Date createdAt;
}

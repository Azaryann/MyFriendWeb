package am.azaryan.myfriendweb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {

  private int id;

  @JsonProperty("sender_id")
  private int senderId;

  @JsonProperty("receiver_id")
  private int receiverId;

  private String message;

  @JsonProperty("created_at")
  private Date createdAt;
}

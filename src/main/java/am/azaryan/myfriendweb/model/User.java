package am.azaryan.myfriendweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private int id;
  private String name;
  private String surname;
  private String email;
  @JsonIgnore
  private String password;
  @JsonProperty("image_url")
  private String imageUrl;
}

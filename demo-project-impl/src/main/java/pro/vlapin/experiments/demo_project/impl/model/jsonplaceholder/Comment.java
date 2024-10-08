package pro.vlapin.experiments.demo_project.impl.model.jsonplaceholder;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder(toBuilder = true)
public class Comment {

  Long id;

  Long postId;

  String name;

  String email;

  String body;
}

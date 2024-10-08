package pro.vlapin.experiments.demo_project.impl.model.jsonplaceholder;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder(toBuilder = true)
public class Todo {

  Long id;

  Long userId;

  String title;

  Boolean completed;
}

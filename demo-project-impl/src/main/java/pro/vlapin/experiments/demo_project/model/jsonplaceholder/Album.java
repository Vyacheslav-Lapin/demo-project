package pro.vlapin.experiments.demo_project.model.jsonplaceholder;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder(toBuilder = true)
public class Album {

  Long id;

  Long userId;

  String title;
}

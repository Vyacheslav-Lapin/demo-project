package pro.vlapin.experiments.demo_project.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

public sealed interface AnnotationBasedSetterPropertiesPlaceholderExample {
  String getHost();
  Integer getPort();
}

/**
* Features:
* - default values (Convention over Configuration)
* - code-completion by IDEA in *.properties and *.yaml files
* - javadoc-comments as a hints in code-completion by IDEA
*
* Limitations:
* - need for no-args-constructor
* - need for PUBLIC setters
*   - so, you have to extract other methods to separate interface and use it by reference
*/
@Data
@Validated
@ConfigurationProperties("my-properties")
final class AnnotationBasedSetterPropertiesPlaceholderExampleImpl
  implements AnnotationBasedSetterPropertiesPlaceholderExample {

  /**
   * My hostname
   */
  @NotBlank
  String host = "localhost";

  /**
   * My port
   */
  @Min(1_000)
  @Max(65_535)
  Integer port = 8080;
}

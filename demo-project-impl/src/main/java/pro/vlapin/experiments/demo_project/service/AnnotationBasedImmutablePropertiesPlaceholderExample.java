package pro.vlapin.experiments.demo_project.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

public sealed interface AnnotationBasedImmutablePropertiesPlaceholderExample {
    String getAuthMethod();
    String getUsername();
    String getPassword();
}

/**
 * Limitations:
 * - no defaults (!!!)
 */
@Getter
@ConfigurationProperties("mail.credentials")
@RequiredArgsConstructor(onConstructor_ = @ConstructorBinding)
final class AnnotationBasedImmutablePropertiesPlaceholderExampleImpl
  implements AnnotationBasedImmutablePropertiesPlaceholderExample {

  /**
   * Auth method
   */
  String authMethod;

  /**
   * login
   */
  String username;

  /**
   * pwd
   */
  String password;

}

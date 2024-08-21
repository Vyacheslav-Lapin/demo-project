package pro.vlapin.experiments.demo_project.model.jsonplaceholder;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.shaded.com.fasterxml.jackson.core.type.TypeReference;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class AddressTest {

  ObjectMapper objectMapper;

  @Test
  @SneakyThrows
  @DisplayName(" works correctly")
  void worksCorrectlyTest() {
    // given
    val address = Address.builder()
                        .zipCode("qwerty")
                        .build();

    val s = objectMapper.writer().withDefaultPrettyPrinter()
                        .writeValueAsString(address);
    System.out.println("s = " + s);

    val value = objectMapper.reader()
//                            .forType(Address.class)
                            .readValue(s, Address.class);

    System.out.println("value = " + value);
  }
}

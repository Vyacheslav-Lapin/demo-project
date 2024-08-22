package pro.vlapin.experiments.demo_project.impl.jsonplaceholder;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.vlapin.experiments.demo_project.impl.model.jsonplaceholder.User;
import pro.vlapin.experiments.demo_project.impl.service.jsonplaceholder.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {

  UserService userService;

  @NotNull
  @GetMapping
  public List<User> all() {
    return userService.all();
  }

  @GetMapping("{id}")
  public User byId(@PathVariable @NotNull Long id) {
    return userService.findById(id);
  }
}

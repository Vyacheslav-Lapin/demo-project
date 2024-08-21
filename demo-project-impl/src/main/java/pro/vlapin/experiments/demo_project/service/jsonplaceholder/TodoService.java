package pro.vlapin.experiments.demo_project.service.jsonplaceholder;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pro.vlapin.experiments.demo_project.model.jsonplaceholder.Todo;

@FeignClient(
    name = "TodoJsonPlaceHolder",
    url = "https://jsonplaceholder.typicode.com",
    path = "todos")
public interface TodoService {

  @GetMapping
  List<Todo> all();

  @GetMapping("{id}")
  Todo findById(@PathVariable Long id);
}

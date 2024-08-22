package pro.vlapin.experiments.demo_project.impl.service.jsonplaceholder;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pro.vlapin.experiments.demo_project.impl.model.jsonplaceholder.Comment;

@FeignClient(
    name = "CommentJsonPlaceHolder",
    url = "https://jsonplaceholder.typicode.com",
    path = "comments")
public interface CommentService {

  @GetMapping
  List<Comment> all();

  @GetMapping("{id}")
  Comment findById(@PathVariable Long id);

  @GetMapping("posts/{postId}/comments")
  List<Comment> commentsByPostId(@PathVariable Long postId);
}

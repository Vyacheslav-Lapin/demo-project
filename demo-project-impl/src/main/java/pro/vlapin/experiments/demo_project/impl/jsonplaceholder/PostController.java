package pro.vlapin.experiments.demo_project.impl.jsonplaceholder;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.vlapin.experiments.demo_project.impl.model.jsonplaceholder.Post;
import pro.vlapin.experiments.demo_project.impl.service.jsonplaceholder.PostService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/posts")
public class PostController {

  PostService postService;

  @NotNull
  @GetMapping
  @Contract(pure = true)
  public List<Post> get() {
    return postService.all();
  }

  @NotNull
  @GetMapping("{id}")
  public Post get(@PathVariable @NotNull Long id) {
    return postService.findById(id);
  }

//  @NotNull
//  @GetMapping
//  @Contract(pure = true)
//  public List<Post> postsByUser(@RequestParam @NotNull Long userId) {
//    return client.postsByUserId(userId);
//  }

//  @NotNull
//  @Contract(pure = true)
//  @GetMapping("{id}/comments")
//  public List<Comment> commentsByPostId(@PathVariable @NotNull Long id) {
//    return postService.commentsByPostId(id);
//  }
}

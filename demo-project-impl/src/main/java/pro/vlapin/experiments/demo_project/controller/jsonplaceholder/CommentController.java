package pro.vlapin.experiments.demo_project.controller.jsonplaceholder;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.vlapin.experiments.demo_project.model.jsonplaceholder.Comment;
import pro.vlapin.experiments.demo_project.service.jsonplaceholder.CommentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/comments")
public class CommentController {

  CommentService commentService;

  @GetMapping
  @Contract(pure = true)
  public List<Comment> comments() {
    return commentService.all();
  }

  @GetMapping("{id}")
  @Contract(pure = true)
  public Comment comment(@PathVariable Long id) {
    return commentService.findById(id);
  }

//  @GetMapping
//  @Contract(pure = true)
//  public List<Comment> commentsByPostId(@RequestParam Long postId) {
//    return client.commentsByPostId(postId);
//  }

}

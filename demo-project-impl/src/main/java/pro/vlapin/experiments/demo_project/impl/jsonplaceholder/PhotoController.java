package pro.vlapin.experiments.demo_project.impl.jsonplaceholder;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.vlapin.experiments.demo_project.impl.model.jsonplaceholder.Photo;
import pro.vlapin.experiments.demo_project.impl.service.jsonplaceholder.PhotoService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/photo")
public class PhotoController {

  PhotoService photoService;

  @GetMapping
  @Contract(pure = true)
  public List<Photo> get() {
    return photoService.all();
  }

  @GetMapping("{id}")
  @Contract(pure = true)
  public Photo get(@PathVariable Long id) {
    return photoService.findById(id);
  }

//  @GetMapping
//  @Contract(pure = true)
//  public List<AlbumImpl> getByPostId(@RequestParam Long postId) {
//    return client.albumsByPostId(postId);
//  }

}

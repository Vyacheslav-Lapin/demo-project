package pro.vlapin.experiments.demo_project.impl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.vlapin.experiments.demo_project.impl.model.Cat;

import java.util.Optional;
import java.util.UUID;

public interface CatRepository extends JpaRepository<Cat, UUID> {
  Optional<Cat> findByName(String name);
}

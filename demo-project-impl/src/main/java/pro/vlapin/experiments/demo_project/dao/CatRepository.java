package pro.vlapin.experiments.demo_project.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.vlapin.experiments.demo_project.model.Cat;

public interface CatRepository extends JpaRepository<Cat, UUID> {
}

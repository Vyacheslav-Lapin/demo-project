package pro.vlapin.experiments.demo_project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@SuppressWarnings({
    "JpaObjectClassSignatureInspection",
    "com.haulmont.jpb.LombokDataInspection",
    "com.intellij.jpb.LombokDataInspection"})
public class Cat {

  @Id
  @GeneratedValue
  @Column(updatable = false, nullable = false)
  UUID id;

  @Version
  int version;

  @NonNull
  String name;

  @Override
  public boolean equals(Object o) {
    return this == o || o != null &&
            Hibernate.getClass(this) == Hibernate.getClass(o)
            && id != null
            && o instanceof Cat cat
            && Objects.equals(id, cat.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}

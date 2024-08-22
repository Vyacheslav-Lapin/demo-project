package pro.vlapin.experiments.demo_project.impl.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.ExtensionMethod;
import org.jetbrains.annotations.Contract;
import pro.vlapin.experiments.demo_project.impl.common.HibernateUtils;

import java.util.Objects;
import java.util.UUID;

import static pro.vlapin.experiments.demo_project.impl.common.HibernateUtils.*;

@Data
@Entity
//@Table(name="Cittens")
@SuppressWarnings({
    "JpaObjectClassSignatureInspection",
    "com.haulmont.jpb.LombokDataInspection",
    "com.intellij.jpb.LombokDataInspection"})
@ExtensionMethod(value = HibernateUtils.class,
                 suppressBaseMethods = false)
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
  @Contract(value = "null -> false", pure = true)
  public final boolean equals(Object o) {
    return this == o || o != null
                        && getEffectiveClass(this) == o.getEffectiveClass()
                        && getId() != null
                        && o instanceof Cat cat
                        && Objects.equals(getId(), cat.getId());
  }

  @Override
  public final int hashCode() {
    return getEffectiveClass(this).hashCode();
  }
}

package pro.vlapin.experiments.demo_project.impl.common;

import lombok.experimental.UtilityClass;
import org.hibernate.proxy.HibernateProxy;

@UtilityClass
public class HibernateUtils {

  public Class<?> getEffectiveClass(Object o) {
    return o instanceof HibernateProxy proxy
                       ? proxy.getHibernateLazyInitializer().getPersistentClass()
                       : o.getClass();
  }
}

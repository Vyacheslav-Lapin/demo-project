package pro.vlapin.experiments.demo_project.impl.common;

import io.vavr.CheckedConsumer;
import io.vavr.CheckedFunction1;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class ScopeFunctions {

  public <T> void with(@NotNull T self,
                       @NotNull CheckedConsumer<T> checkedConsumer) {
    checkedConsumer.unchecked().accept(self);
  }

  public <T> @NotNull T peakWith(@NotNull T self,
                                 @NotNull CheckedConsumer<T> checkedConsumer) {
    with(self, checkedConsumer);
    return self;
  }

  public <T, R> @NotNull R mapWith(@NotNull T self,
                                   @NotNull CheckedFunction1<T, R> mapper) {
    return mapper.unchecked().apply(self);
  }
}

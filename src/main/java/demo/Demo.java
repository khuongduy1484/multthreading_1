package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i < 1000; i++) {
      int personId = i;
      executorService.execute(new Person(i) {
      });
    }
    executorService.shutdown();
  }
}

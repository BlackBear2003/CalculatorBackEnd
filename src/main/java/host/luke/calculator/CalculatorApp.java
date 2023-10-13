package host.luke.calculator;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CalculatorApp {

  public static void main(String[] args) {
    new SpringApplicationBuilder(CalculatorApp.class).run(args);
  }

}

package host.luke.calculator.controller;

import host.luke.calculator.entity.CalculateResult;
import host.luke.calculator.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CalculateController.class)
public class CalculateControllerIntegrationTest{

  @SpyBean
  CalculateController calculateController;

  @MockBean
  CalculateService calculateService;

  @Test
  void testFindById() {

    long id = 1;
    CalculateResult calculateResult = new CalculateResult(id, "1+1", "2");

    Mockito.when(calculateService.findById(Mockito.eq(id)))
        .thenReturn(calculateResult);

    CalculateResult result = calculateController.findById(id);

    Assertions.assertEquals(calculateResult, result);

    Mockito.verify(calculateService, Mockito.times(1))
        .findById(Mockito.eq(id));
  }

}

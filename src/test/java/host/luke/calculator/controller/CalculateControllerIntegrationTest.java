package host.luke.calculator.controller;


import host.luke.calculator.service.CalculateService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

public class CalculateControllerIntegrationTest extends AbstractControllerIntegrationTest{

  @SpyBean
  CalculateController calculateController;

  @MockBean
  CalculateService calculateService;

  


}

package host.luke.calculator.controller;

import host.luke.calculator.entity.CalculateResult;
import host.luke.calculator.service.CalculateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

  private final CalculateService calculateService;

  public CalculateController(CalculateService calculateService) {
    this.calculateService = calculateService;
  }

  @GetMapping
  public CalculateResult findById(long id) {
    return calculateService.findById(id);
  }

  @PostMapping
  public CalculateResult saveResult(CalculateResult calculateResult) {
    return calculateService.save(calculateResult);
  }

}

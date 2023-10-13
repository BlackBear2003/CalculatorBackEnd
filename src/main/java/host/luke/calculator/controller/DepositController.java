package host.luke.calculator.controller;

import host.luke.calculator.entity.DepositInterest;
import host.luke.calculator.service.DepositService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deposit")
public class DepositController {

  private final DepositService depositService;

  public DepositController(DepositService depositService) {
    this.depositService = depositService;
  }

  @GetMapping
  public List<DepositInterest> findAll() {
    return depositService.findAll();
  }

  @PostMapping
  public DepositInterest create(String periodDescription, Double period, String interest) {
    System.out.println(interest);
    DepositInterest depositInterest = new DepositInterest();
    depositInterest.setPeriodDescription(periodDescription);
    depositInterest.setPeriod(period);
    depositInterest.setInterest(new BigDecimal(interest));
    return depositService.save(depositInterest);
  }

  @PutMapping
  public DepositInterest update(@RequestBody DepositInterest depositInterest) {
    return depositService.save(depositInterest);
  }

  @DeleteMapping
  public void delete(long id) {
    depositService.delete(id);
  }

  @GetMapping("/suitable")
  public DepositInterest findSuitable(Double period) {
    return depositService.findSuitableByPeriod(period);
  }

}

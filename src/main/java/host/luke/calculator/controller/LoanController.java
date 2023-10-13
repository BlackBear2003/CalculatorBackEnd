package host.luke.calculator.controller;

import host.luke.calculator.entity.LoanInterest;
import host.luke.calculator.service.LoanService;
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
@RequestMapping("/loan")
public class LoanController {

  private final LoanService loanService;

  public LoanController(LoanService loanService) {
    this.loanService = loanService;
  }

  @GetMapping
  public List<LoanInterest> findAll() {
    return loanService.findAll();
  }

  @PostMapping
  public LoanInterest create(String periodDescription, Double period, String interest) {
    LoanInterest loanInterest = new LoanInterest();
    loanInterest.setPeriodDescription(periodDescription);
    loanInterest.setPeriod(period);
    loanInterest.setInterest(new BigDecimal(interest));
    return loanService.save(loanInterest);
  }

  @PutMapping
  public LoanInterest update(@RequestBody LoanInterest loanInterest) {
    return loanService.save(loanInterest);
  }

  @DeleteMapping
  public void delete(long id) {
    loanService.delete(id);
  }

  @GetMapping("/suitable")
  public LoanInterest findSuitable(Double period) {
    return loanService.findSuitableByPeriod(period);
  }
}

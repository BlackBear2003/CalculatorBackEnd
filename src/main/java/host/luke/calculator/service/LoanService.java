package host.luke.calculator.service;

import host.luke.calculator.entity.LoanInterest;
import host.luke.calculator.repository.LoanInterestRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

  private final LoanInterestRepository loanInterestRepository;

  public LoanService(LoanInterestRepository loanInterestRepository) {
    this.loanInterestRepository = loanInterestRepository;
  }

  public LoanInterest save(LoanInterest loanInterest) {
    return loanInterestRepository.save(loanInterest);
  }

  public void delete(long id) {
    loanInterestRepository.deleteById(id);
  }

  public List<LoanInterest> findAll() {
    Sort sort = Sort.by(Direction.ASC, "Period");
    return loanInterestRepository.findAll(sort);
  }

  public LoanInterest findSuitableByPeriod(Double period) {
    return loanInterestRepository.findTopByPeriodLessThanEqualOrderByPeriodDesc(period);
  }

}

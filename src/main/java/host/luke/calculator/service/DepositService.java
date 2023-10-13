package host.luke.calculator.service;

import host.luke.calculator.entity.DepositInterest;
import host.luke.calculator.repository.DepositInterestRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class DepositService {

  private final DepositInterestRepository depositInterestRepository;

  public DepositService(DepositInterestRepository depositInterestRepository) {
    this.depositInterestRepository = depositInterestRepository;
  }

  public DepositInterest save(DepositInterest depositInterest) {
    return depositInterestRepository.save(depositInterest);
  }

  public void delete(long id) {
    depositInterestRepository.deleteById(id);
  }

  public List<DepositInterest> findAll() {
    Sort sort = Sort.by(Direction.ASC, "Period");
    return depositInterestRepository.findAll(sort);
  }

  public DepositInterest findSuitableByPeriod(Double period) {
    return depositInterestRepository.findTopByPeriodLessThanEqualOrderByPeriodDesc(period);
  }

}

package host.luke.calculator.repository;

import host.luke.calculator.entity.LoanInterest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanInterestRepository extends JpaRepository<LoanInterest, Long> {

  LoanInterest findTopByPeriodLessThanEqualOrderByPeriodDesc(Double period);
}

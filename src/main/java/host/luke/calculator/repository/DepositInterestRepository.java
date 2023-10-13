package host.luke.calculator.repository;

import host.luke.calculator.entity.DepositInterest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositInterestRepository extends JpaRepository<DepositInterest, Long> {

  DepositInterest findTopByPeriodLessThanEqualOrderByPeriodDesc(Double period);

}

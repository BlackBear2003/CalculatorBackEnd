package host.luke.calculator.repository;

import host.luke.calculator.entity.CalculateResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculateResultRepository extends JpaRepository<CalculateResult, Long> {

}

package host.luke.calculator.service;

import host.luke.calculator.entity.CalculateResult;
import host.luke.calculator.repository.CalculateResultRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {

  private final CalculateResultRepository calculateResultRepository;

  public CalculateService(CalculateResultRepository calculateResultRepository) {
    this.calculateResultRepository = calculateResultRepository;
  }

  public CalculateResult save(CalculateResult calculateResult) {
    return calculateResultRepository.save(calculateResult);
  }

  public CalculateResult findById(long id) {
    return calculateResultRepository.findById(id).orElse(new CalculateResult(0L, "", "0"));
  }

}

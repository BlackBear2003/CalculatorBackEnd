package host.luke.calculator.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import host.luke.calculator.component.BigDecimalConverter;
import host.luke.calculator.component.BigDecimalToStringSerializer;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LoanInterest")
public class LoanInterest {

  @Id
  @Column(name = "Id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "PeriodDescription")
  private String periodDescription;

  @Column(name = "Period")
  private Double period;

  @Convert(converter = BigDecimalConverter.class)
  @Column(name = "Interest")
  @JsonSerialize(using = BigDecimalToStringSerializer.class)
  private BigDecimal interest;


  public LoanInterest(Long id, String periodDescription, Double period,
      BigDecimal interest) {
    this.id = id;
    this.periodDescription = periodDescription;
    this.period = period;
    this.interest = interest;
  }

  public LoanInterest() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPeriodDescription() {
    return periodDescription;
  }

  public void setPeriodDescription(String periodDescription) {
    this.periodDescription = periodDescription;
  }

  public Double getPeriod() {
    return period;
  }

  public void setPeriod(Double period) {
    this.period = period;
  }

  public BigDecimal getInterest() {
    return interest;
  }

  public void setInterest(BigDecimal interest) {
    this.interest = interest;
  }

}

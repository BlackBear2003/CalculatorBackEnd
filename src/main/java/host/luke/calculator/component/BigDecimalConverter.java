package host.luke.calculator.component;

import java.math.BigDecimal;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class BigDecimalConverter implements AttributeConverter<BigDecimal, String> {

  @Override
  public String convertToDatabaseColumn(BigDecimal attribute) {
    if (attribute == null) {
      return null;
    }
    return attribute.toString();
  }

  @Override
  public BigDecimal convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }
    return new BigDecimal(dbData);
  }
}

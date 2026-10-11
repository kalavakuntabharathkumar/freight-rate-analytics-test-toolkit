package com.example.freight;
import java.math.*;
import java.util.Objects;
public record RateQuote(String carrier,String origin,String destination,BigDecimal weightKg,BigDecimal baseRate,BigDecimal perKgRate) {
 public RateQuote { Objects.requireNonNull(carrier);Objects.requireNonNull(origin);Objects.requireNonNull(destination);Objects.requireNonNull(weightKg);Objects.requireNonNull(baseRate);Objects.requireNonNull(perKgRate);
  if(weightKg.signum()<=0||baseRate.signum()<0||perKgRate.signum()<0)throw new IllegalArgumentException("Weight must be positive and rates cannot be negative");}
 public BigDecimal total(){return baseRate.add(perKgRate.multiply(weightKg)).setScale(2,RoundingMode.HALF_UP);}
}
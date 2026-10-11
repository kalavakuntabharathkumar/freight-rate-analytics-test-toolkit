package com.example.freight;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class RateCalculatorTest {
 private final RateCalculator calculator=new RateCalculator();
 @Test void calculatesBasePlusWeightRate(){var q=new RateQuote("FastShip","Chennai","Pune",new BigDecimal("10"),new BigDecimal("100"),new BigDecimal("12.50"));assertEquals(new BigDecimal("225.00"),calculator.calculate(q));}
 @Test void findsCheapestCarrier(){var a=new RateQuote("A","X","Y",new BigDecimal("2"),new BigDecimal("80"),new BigDecimal("10"));var b=new RateQuote("B","X","Y",new BigDecimal("2"),new BigDecimal("50"),new BigDecimal("5"));assertEquals("B",calculator.cheapest(List.of(a,b)).orElseThrow().carrier());}
 @Test void rejectsZeroWeight(){assertThrows(IllegalArgumentException.class,()->new RateQuote("A","X","Y",BigDecimal.ZERO,BigDecimal.ONE,BigDecimal.ONE));}
}
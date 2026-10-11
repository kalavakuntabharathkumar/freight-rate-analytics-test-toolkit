package com.example.freight;
import java.math.BigDecimal;
import java.util.*;
public class RateCalculator {
 public BigDecimal calculate(RateQuote quote){return quote.total();}
 public Optional<RateQuote> cheapest(List<RateQuote> quotes){return quotes.stream().min(Comparator.comparing(RateQuote::total));}
}
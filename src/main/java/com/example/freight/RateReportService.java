package com.example.freight;
import java.time.LocalDate;
import java.util.*;
public class RateReportService {
 private final ReportRepository repository;
 public RateReportService(ReportRepository repository){this.repository=Objects.requireNonNull(repository);}
 public List<RouteDailySummary> summarize(LocalDate from,LocalDate to){
  if(from==null||to==null||from.isAfter(to))throw new IllegalArgumentException("from must be on or before to");
  return repository.summarize(from,to);
 }
}
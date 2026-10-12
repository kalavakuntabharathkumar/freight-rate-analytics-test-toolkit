package com.example.freight;
import java.time.LocalDate;
import java.util.List;
public interface ReportRepository { List<RouteDailySummary> summarize(LocalDate from,LocalDate to); }
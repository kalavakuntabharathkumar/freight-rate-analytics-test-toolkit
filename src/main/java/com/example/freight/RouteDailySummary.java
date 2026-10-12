package com.example.freight;
import java.math.BigDecimal;
import java.time.LocalDate;
public record RouteDailySummary(LocalDate day,String origin,String destination,long shipmentCount,BigDecimal revenue) {}
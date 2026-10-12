package com.example.freight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class RateReportServiceTest {
 @Mock ReportRepository repository; @InjectMocks RateReportService service;
 @Test void delegatesValidRange(){var a=LocalDate.parse("2026-01-01");var b=LocalDate.parse("2026-01-31");when(repository.summarize(a,b)).thenReturn(List.of());assertTrue(service.summarize(a,b).isEmpty());verify(repository).summarize(a,b);}
 @Test void rejectsInvertedRangeWithoutDatabaseCall(){var a=LocalDate.parse("2026-02-01");var b=LocalDate.parse("2026-01-01");assertThrows(IllegalArgumentException.class,()->service.summarize(a,b));verifyNoInteractions(repository);}
}
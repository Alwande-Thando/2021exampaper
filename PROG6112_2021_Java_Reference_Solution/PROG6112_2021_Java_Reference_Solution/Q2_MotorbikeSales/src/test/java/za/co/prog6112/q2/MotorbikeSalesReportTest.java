package za.co.prog6112.q2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotorbikeSalesReportTest {
    private final MotorbikeSalesReport report = new MotorbikeSalesReport();

    @Test void triumphTotalIs1100() { assertEquals(1100, report.totalSales(0)); }
    @Test void hondaReceivesSilverStatus() { assertEquals("Silver", report.statusFor(1)); }
    @Test void suzukiReceivesGoldStatusAtThreshold() { assertEquals("Gold", report.statusFor(2)); }
    @Test void ducatiTotalIs900() { assertEquals(900, report.totalSales(4)); }
}

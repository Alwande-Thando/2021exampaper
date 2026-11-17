package za.co.prog6112.q2;

/** Stores quarterly motorbike sales and reports totals and manufacturer status. */
public class MotorbikeSalesReport {
    private final String[] manufacturers = {"Triumph", "Honda", "Suzuki", "Yamaha", "Ducati"};
    // Each row is a manufacturer; columns are Quarter 1, Quarter 2 and Quarter 3.
    private final int[][] quarterlySales = {
        {500, 100, 500},
        {70, 80, 200},
        {100, 100, 200},
        {100, 70, 50},
        {300, 100, 500}
    };

    public String[] getManufacturers() { return manufacturers.clone(); }

    public int totalSales(int manufacturerIndex) {
        int total = 0;
        for (int amount : quarterlySales[manufacturerIndex]) total += amount;
        return total;
    }

    public String statusFor(int manufacturerIndex) {
        return totalSales(manufacturerIndex) >= 300 ? "Gold" : "Silver";
    }

    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append(String.format("%-14s %10s %10s %10s %10s %10s%n",
                "Brand", "Quarter 1", "Quarter 2", "Quarter 3", "Total", "Status"));
        for (int i = 0; i < manufacturers.length; i++) {
            report.append(String.format("%-14s %10d %10d %10d %10d %10s%n",
                    manufacturers[i], quarterlySales[i][0], quarterlySales[i][1],
                    quarterlySales[i][2], totalSales(i), statusFor(i)));
        }
        return report.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MotorbikeSalesReport().createReport());
    }
}

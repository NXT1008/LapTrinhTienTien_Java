
package Models;

public class chartHoaDon {
    private String month;
    private long total;

    public chartHoaDon(String month, long total) {
        this.month = month;
        this.total = total;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "chartHoaDon{" + "month=" + month + ", total=" + total + '}';
    }
}

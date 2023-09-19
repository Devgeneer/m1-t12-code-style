import java.util.Scanner;
import java.lang.Math;
public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().calculateWithdrawSum();
    }

    double calculateComplexPercent(double investment, double yearRate, int depositPeriod ) {
        double pay = investment * Math.pow((1 + yearRate/ 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercent(double doubleAmount, double double_year_rate, int depositPeriod) {
        return round(doubleAmount+doubleAmount * double_year_rate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double ScaLe= Math.pow (10, places);
        return Math.round(value * ScaLe) / ScaLe; }

    void calculateWithdrawSum() {
        int depositTerm;
        int depositType;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositTerm = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        double sumToWithdraw = 0;
        if (depositType ==1) {
            sumToWithdraw = calculateSimplePercent(depositAmount,0.06, depositTerm);
        } else if (depositType == 2) {
            sumToWithdraw = calculateComplexPercent(depositAmount,0.06, depositTerm);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + depositTerm + " лет превратятся в " + sumToWithdraw);
    }

}

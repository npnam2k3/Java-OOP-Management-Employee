package managerEmployee;

import java.util.Scanner;

public class Director extends Employee {
    private float companySharePercentage;
    private static final float DEFAULT_DAILY_SALARY = 300f;

    public Director(){}
    public Director(String id, String fullname, String birthDate, String phoneNumber, int numOfWorkingDay) {
        super(id, fullname, birthDate, phoneNumber, numOfWorkingDay, DEFAULT_DAILY_SALARY);
    }

    public float getCompanySharePercentage() {
        return companySharePercentage;
    }

    public void setCompanySharePercentage(float companySharePercentage) {
        if (companySharePercentage > 0 && companySharePercentage <= 100)
            this.companySharePercentage = companySharePercentage;
        else
            this.companySharePercentage = 0;
    }

    public static float getDefaultDailySalary() {
        return DEFAULT_DAILY_SALARY;
    }

    @Override
    public void enterInfor(Scanner scanner) {
        super.enterInfor(scanner);
        System.out.println("Nhập vào số cổ phần đang sở hữu (%):");
        float sharePercentage;
        while (true) {
            sharePercentage = scanner.nextFloat();
            if (sharePercentage > 0 && sharePercentage <= 100) {
                this.setCompanySharePercentage(sharePercentage);
                break;
            } else {
                System.out.println("Phần trăm cổ phần phải nằm trong khoảng từ 0 đến 100. Vui lòng nhập lại:");
            }
        }
        scanner.nextLine(); //đọc ký tự enter trong bộ đệm sau khi nhập 1 số
    }

    @Override
    public float calculateSalary() {
        return (super.getNumOfWorkingDay() * DEFAULT_DAILY_SALARY);
    }

    @Override
    public String toString() {
        return super.toString() + "\nLương 1 ngày: "+getDefaultDailySalary()+
                "\nLương tháng: "+calculateSalary()+
                "\nSố cổ phần đang sở hữu: "+getCompanySharePercentage()+"%";
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Director director = new Director();
//        director.enterInfor(scanner);
//    }
}

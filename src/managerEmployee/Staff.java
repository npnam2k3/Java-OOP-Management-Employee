package managerEmployee;

import java.util.Scanner;

public class Staff extends Employee {
    private Manager manager = null;
    private static final float DEFAULT_DAILY_SALARY = 100f;

    public Staff() {
    }

    public Staff(String id, String fullname, String birthDate, String phoneNumber, int numOfWorkingDay, Manager manager) {
        super(id, fullname, birthDate, phoneNumber, numOfWorkingDay, DEFAULT_DAILY_SALARY);
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public float calculateSalary() {
        return (super.getNumOfWorkingDay() * DEFAULT_DAILY_SALARY);
    }

    public static float getDefaultDailySalary() {
        return DEFAULT_DAILY_SALARY;
    }

    @Override
    public void enterInfor(Scanner scanner) {
        super.enterInfor(scanner);
    }

    @Override
    public String toString() {
        return super.toString() + "\nLương 1 ngày: " + getDefaultDailySalary() +
                "\nLương tháng: "+calculateSalary()+
                "\nQuản lý: " + (manager != null ? manager.getFullname() : "Không có");
    }

}

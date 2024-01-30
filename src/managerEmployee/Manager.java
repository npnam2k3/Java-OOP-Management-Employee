package managerEmployee;

import java.util.Scanner;

public class Manager extends Employee {
    private int numStaffManager = 0;
    private static final float DEFAULT_DAILY_SALARY = 200f;

    public Manager() {

    }

    public Manager(String id, String fullname, String birthDate, String phoneNumber, int numOfWorkingDay, int numStaffManager) {
        super(id, fullname, birthDate, phoneNumber, numOfWorkingDay, DEFAULT_DAILY_SALARY);
        this.numStaffManager = numStaffManager;
    }

    public int getNumStaffManager() {
        return numStaffManager;
    }

    public void setNumStaffManager(int numStaffManager) {
        this.numStaffManager = numStaffManager;
    }

    public static float getDefaultDailySalary() {
        return DEFAULT_DAILY_SALARY;
    }

    public void addEmployeeManager(Staff staff) {
        numStaffManager++;
        staff.setManager(this); //this: đối tượng hiện tại đang thực thi phương thức này
    }

    @Override
    public void enterInfor(Scanner scanner) {
        super.enterInfor(scanner);
        System.out.println("Nhập vào số lượng nhân viên đang quản lý: ");
        numStaffManager = scanner.nextInt();
        scanner.nextLine(); //đọc ký tự enter trong bộ đệm sau khi nhập 1 số
    }

    @Override
    public float calculateSalary() {
        return ((super.getNumOfWorkingDay() * DEFAULT_DAILY_SALARY) + (100 * numStaffManager));
    }

    @Override
    public String toString() {
        return super.toString() + "\nLương 1 ngày: " + getDefaultDailySalary() +
                "\nLương tháng: "+calculateSalary()+
                "\nSố lượng nhân viên đang quản lý: " + getNumStaffManager();
    }
}

package managerEmployee;

import java.util.Scanner;

public abstract class Employee {
    private String id;
    private String fullname;
    private String birthDate; //dd/mm/yyyy
    private String phoneNumber;
    private int numOfWorkingDay;
    private float dailySalary;

    public Employee() {
    }

    public Employee(String id, String fullname, String birthDate, String phoneNumber, int numOfWorkingDay, float dailySalary) {
        this.id = id;
        this.fullname = fullname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.numOfWorkingDay = numOfWorkingDay;
        this.dailySalary = dailySalary;
    }

    public abstract float calculateSalary();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumOfWorkingDay() {
        return numOfWorkingDay;
    }

    public void setNumOfWorkingDay(int numOfWorkingDay) {
        this.numOfWorkingDay = numOfWorkingDay;
    }

    public float getDailySalary() {
        return dailySalary;
    }

    public void setDailySalary(float dailySalary) {
        this.dailySalary = dailySalary;
    }

    public void validateAndEnterId(Scanner scanner) {
        boolean check;
        do {
            check = false;
            System.out.println("Nhập vào mã số nhân viên:");
            id = scanner.nextLine();
            if (Validate.validateId(id) && !id.equalsIgnoreCase("null")) {
                check = true;
            } else {
                System.out.println("Mã số không hợp lệ, vui lòng nhập lại.");
            }
        } while (check == false);
    }

    public void validateAndEnterFullname(Scanner scanner) {
        boolean check;
        do {
            check = false;
            System.out.println("Nhập vào họ tên nhân viên:");
            fullname = scanner.nextLine();
            if (Validate.validateName(fullname) && !fullname.equalsIgnoreCase("null")) {
                check = true;
            } else {
                System.out.println("Họ tên không hợp lệ, vui lòng nhập lại.");
            }
        } while (check == false);
    }

    public void validateAndEnterBirthOfDate(Scanner scanner) {
        boolean check;
        do {
            check = false;
            System.out.println("Nhập vào ngày tháng năm sinh (dd/mm/yyyy):");
            birthDate = scanner.nextLine();
            if (Validate.validateBirthDate(birthDate)) {
                check = true;
            } else {
                System.out.println("Ngày tháng năm sinh không hợp lệ, vui lòng nhập lại.");
            }
        } while (check == false);
    }

    public void validateAndEnterPhoneNumber(Scanner scanner) {
        boolean check;
        do {
            check = false;
            System.out.println("Nhập vào số điện thoại (10 số):");
            phoneNumber = scanner.nextLine();
            if (Validate.validatePhoneNumber(phoneNumber) && !phoneNumber.equalsIgnoreCase("null")) {
                check = true;
            } else {
                System.out.println("Số điện thoại không hợp lệ, vui lòng nhập lại.");
            }
        } while (check == false);
    }

    public void validateAndEnterNumOfWorkingDay(Scanner scanner) {
        boolean check;
        do {
            check = false;
            System.out.println("Nhập vào số ngày làm việc:");
            try {
                numOfWorkingDay = scanner.nextInt();
                if (Validate.validateNumOfWorkingDay(numOfWorkingDay)) {
                    check = true;
                } else {
                    System.out.println("Số ngày làm việc không hợp lệ, vui lòng nhập lại.");
                }
            } catch (Exception e) {
                System.out.println("Số ngày làm việc không hợp lệ, vui lòng nhập lại.");
            }
            scanner.nextLine(); //loại bỏ dữ liệu không hợp lệ ra khỏi bộ đệm scaner
        } while (check == false);
    }

    public void enterInfor(Scanner scanner) {
        validateAndEnterId(scanner);
        validateAndEnterFullname(scanner);
        validateAndEnterBirthOfDate(scanner);
        validateAndEnterPhoneNumber(scanner);
        validateAndEnterNumOfWorkingDay(scanner);
    }

    @Override
    public String toString() {
        return "Mã số NV: " + id + "\nHọ tên: " + fullname + "\nNgày sinh: " + birthDate + "\nSố điện thoại: " + phoneNumber + "\nSố ngày làm việc: " + numOfWorkingDay;
    }

}

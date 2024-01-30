package managerEmployee;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        EmployeeResourceManager employeeResourceManager = company.getEmployeeResourceManager();
        Scanner scanner = new Scanner(System.in);
//        EmployeeResourceManager erm = new EmployeeResourceManager();
//        erm.addEmployee(scanner);
//        erm.displayEmployee();
        int choose = 1;
        do {
            System.out.println("========= QUẢN LÝ NHÂN SỰ ============");
            System.out.println("1. Nhập thông tin công ty");
            System.out.println("2. Nhập thông tin nhân sự");
            System.out.println("3. Phân bổ Nhân viên vào Trưởng phòng quản lý");
            System.out.println("4. Xuất thông tin toàn bộ nhân viên trong công ty");
            System.out.println("5. Thêm nhân sự mới");
            System.out.println("6. Xóa nhân sự");
            System.out.println("7. Tính và xuất tổng lương cho toàn công ty");
            System.out.println("8. Tìm nhân viên thường có lương cao nhất");
            System.out.println("9. Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất");
            System.out.println("10. Sắp xếp nhân viên toàn công ty theo thứ tự abc");
            System.out.println("11. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần");
            System.out.println("12. Tìm Giám Đốc có số lượng cổ phần nhiều nhất");
            System.out.println("13. Tính và xuất tổng thu nhập của từng Giám Đốc");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng chọn chức năng: ");
            String input = scanner.nextLine();
            try {
                choose = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                continue;
            }
            switch (choose) {
                case 1: {
                    company.enterInfor(scanner);
                    break;
                }
                case 2: {
                    employeeResourceManager.addEmployee(scanner);
                    break;
                }
                case 3: {
                    employeeResourceManager.assignEmployeeToManager(scanner);
                    break;
                }
                case 4: {
                    employeeResourceManager.displayEmployee();
                    break;
                }
                case 5: {
                    employeeResourceManager.addEmployee(scanner);
                    break;
                }
                case 6: {
                    System.out.println("Nhập vào mã nhân sự cần xóa: ");
                    String employeeId = scanner.nextLine();
                    if (employeeResourceManager.removeEmployee(employeeId)) {
                        System.out.println("Xóa thành công nhân sự có mã: " + employeeId);
                    } else {
                        System.out.println("Xóa không thành công nhân sự có mã: " + employeeId);
                    }
                    break;
                }
                case 7: {
                    employeeResourceManager.calculateAndDisplayTotalSalary();
                    break;
                }
                case 8: {
                    List<Employee> list = employeeResourceManager.findHighestSalaryStaff();
                    System.out.println("Danh sách nhân viên có lương cao nhất là: ");
                    for (Employee employee: list){
                        System.out.println(employee.toString());
                    }
                    break;
                }
                case 9:{
                    List<Employee> list = employeeResourceManager.findManagerWithMostSubordinates();
                    System.out.println("Danh sách trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất: ");
                    for (Employee employee: list){
                        System.out.println(employee.toString());
                    }
                    break;
                }
                case 10:{
                    employeeResourceManager.sortEmployeeByName();
                    break;
                }
                case 11:{
                    employeeResourceManager.sortEmployeeBySalaryDesc();
                    break;
                }
                case 12:{
                    List<Employee> list= employeeResourceManager.findDirectorWithMostShares();
                    System.out.println("Danh sách Giám Đốc có số lượng cổ phần nhiểu nhất: ");
                    for (Employee employee: list){
                        System.out.println(employee.toString());
                    }
                    break;
                }
                case 13:{
                    employeeResourceManager.calculateAndPrintTotalIncomeOfDirectors();
                    break;
                }
                case 0:
                    System.out.println("Thoát chọn.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại: ");
            }
        } while (choose != 0);

    }
}

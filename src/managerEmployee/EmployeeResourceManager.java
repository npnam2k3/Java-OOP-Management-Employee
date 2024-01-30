package managerEmployee;

import java.util.*;

public class EmployeeResourceManager {
    private List<Employee> listEmployee;

    public EmployeeResourceManager() {
        listEmployee = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        listEmployee.add(employee);
    }

    //Nhập thông tin nhân sự - thêm thông tin nhân sự
    public void addEmployee(Scanner scanner) {
        Employee employee;
        int choose = 1;
        do {
            System.out.println("Nhập vào loại nhân viên (1-Nhân viên thường, 2-Trưởng phòng, 3-Giám đốc, 0-Thoát): ");
            String input = scanner.nextLine();
            try {
                choose = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                continue; //nếu có lỗi thì bỏ qua lần lặp hiện tại
            }

            switch (choose) {
                case 1:
                    employee = new Staff();
                    employee.enterInfor(scanner);
                    addEmployee(employee);
                    break;
                case 2:
                    employee = new Manager();
                    employee.enterInfor(scanner);
                    addEmployee(employee);
                    break;
                case 3:
                    employee = new Director();
                    employee.enterInfor(scanner);
                    addEmployee(employee);
                    break;
                case 0:
                    System.out.println("Thoát nhập liệu.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
            }
        } while (choose != 0);
    }

    //hàm xóa nhân viên
    public boolean removeEmployee(String id) {
        boolean result = false;
        Employee employee = findEmployeeById(id);
        if (employee != null && employee instanceof Manager) {
            Manager manager = (Manager) employee;
            //ngắt liên kết các nhân viên có liên kết với trưởng phòng cần xóa
            for (Employee employee1 : listEmployee) {
                if (employee1 instanceof Staff) {
                    Staff staff = (Staff) employee1;
                    Manager staffManager = staff.getManager();
                    if (staffManager != null && staffManager.getId().equalsIgnoreCase(manager.getId())) {
                        staff.setManager(null);
                    }
                }
            }
            listEmployee.remove(manager);
            result = true;
        } else if (employee != null) {
            listEmployee.remove(employee);
            result = true;
        }
        return result;
    }

    //Phân bổ nhân viên vào trưởng phòng
    public void assignEmployeeToManager(Scanner scanner) {
        System.out.println("Nhập vào mã nhân viên cần phân bổ: ");
        String employeeId = scanner.nextLine();
        System.out.println("Nhập vào mã trưởng phòng quản lý nhân viên này: ");
        String managerId = scanner.nextLine();

        Employee staff = this.findEmployeeById(employeeId);
        Manager manager = this.findManagerById(managerId);

        if (staff != null && manager != null && staff instanceof Staff) {
            manager.addEmployeeManager((Staff) staff);
            System.out.println("Nhân viên " + staff.getFullname() +
                    " được phân bổ vào trưởng phòng " + manager.getFullname() + " quản lý");
        } else {
            System.out.println("Không tìm thấy mã nhân viên hoặc trưởng phòng");
        }
    }

    //tính và xuất tổng lương cho toàn công ty
    public void calculateAndDisplayTotalSalary() {
        float totalSalary = 0;
        for (Employee employee : listEmployee) {
            totalSalary += employee.calculateSalary();
        }
        System.out.println("Tổng lương của toàn công ty là: " + totalSalary);
    }

    //Tìm các nhân viên thường có lương cao nhất
    public List<Employee> findHighestSalaryStaff() {
        float maxSalary = findHighestSalary();
        List<Employee> highestSalaryStaff = new ArrayList<>();
        for (Employee employee : listEmployee) {
            if (employee instanceof Staff && employee.calculateSalary() == maxSalary) {
                highestSalaryStaff.add(employee);
            }
        }
        return highestSalaryStaff;
    }

    //tìm mức lương cao nhất của trong các nhân viên thường
    public float findHighestSalary() {
        float maxSalary = 0;
        for (Employee employee : listEmployee) {
            if (employee instanceof Staff) {
                if (employee.calculateSalary() > maxSalary) {
                    maxSalary = employee.calculateSalary();
                }
            }
        }
        return maxSalary;
    }

    //Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất
    public List<Employee> findManagerWithMostSubordinates() {
        List<Employee> listManager = new ArrayList<>();
        int maxQuantity = getQuantityWithHighestStaff();
        for (Employee employee : listEmployee) {
            if (employee instanceof Manager && ((Manager) employee).getNumStaffManager() == maxQuantity) {
                listManager.add(employee);
            }
        }
        return listManager;
    }

    //Tìm số lượng nhân viên dưới quyền nhiều nhất của các quản lý
    public int getQuantityWithHighestStaff() {
        int maxQuantity = 0;
        for (Employee employee : listEmployee) {
            if (employee instanceof Manager) {
                if (((Manager) employee).getNumStaffManager() > maxQuantity) {
                    maxQuantity = ((Manager) employee).getNumStaffManager();
                }
            }
        }
        return maxQuantity;
    }


    public Employee findEmployeeById(String id) {
        for (Employee employee : listEmployee) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    public Manager findManagerById(String id) {
        Employee employee = this.findEmployeeById(id);
        if (employee instanceof Manager) {
            return (Manager) employee;
        }
        return null;
    }

    public void displayEmployee() {
        System.out.println("Danh sách nhân viên toàn công ty:");
        for (Employee employee : listEmployee) {
            System.out.println(employee.toString());
            System.out.println("============");
        }
    }

    public void sortEmployeeByName() {
        Collections.sort(listEmployee, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getFullname().compareTo(o2.getFullname());
            }
        });
    }

    public void sortEmployeeBySalaryDesc() {
        Collections.sort(listEmployee, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Float.compare(o2.calculateSalary(), o1.calculateSalary());
            }
        });
    }

    //tính số lượng cổ phần lớn nhất
    public float calculateLargestShareAmount() {
        float maxNumberShare = 0;
        for (Employee employee : listEmployee) {
            if (employee instanceof Director) {
                if (((Director) employee).getCompanySharePercentage() > maxNumberShare) {
                    maxNumberShare = ((Director) employee).getCompanySharePercentage();
                }
            }
        }
        return maxNumberShare;
    }

    //tìm Giám đốc có số cổ phần nhiều nhất
    public List<Employee> findDirectorWithMostShares() {
        List<Employee> list = new ArrayList<>();
        float maxNumberShare = calculateLargestShareAmount();
        for (Employee employee : listEmployee) {
            if (employee instanceof Director && ((Director) employee).getCompanySharePercentage() == maxNumberShare) {
                list.add(employee);
            }
        }
        return list;
    }

    //tính và xuất tổng lương của các giám đốc
    public void calculateAndPrintTotalIncomeOfDirectors() {
        for (Employee employee : listEmployee) {
            if (employee instanceof Director) {
                System.out.println("Giám đốc " + employee.getFullname() + " có thu nhập là: " + employee.calculateSalary());
            }
        }
    }
}

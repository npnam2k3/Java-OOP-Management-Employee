package managerEmployee;

import java.util.Scanner;

public class Company {
    private String nameCompany;
    private String taxCode;
    private float monthlyRevenue;
    private EmployeeResourceManager employeeResourceManager;

    public Company() {
        employeeResourceManager = new EmployeeResourceManager();
    }

    public Company(String nameCompany, String taxCode, float monthlyRevenue) {
        this.nameCompany = nameCompany;
        this.taxCode = taxCode;
        this.monthlyRevenue = monthlyRevenue;
        employeeResourceManager = new EmployeeResourceManager();
    }

    public EmployeeResourceManager getEmployeeResourceManager() {
        return employeeResourceManager;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public float getMonthlyRevenue() {
        return monthlyRevenue;
    }

    public void setMonthlyRevenue(float monthlyRevenue) {
        this.monthlyRevenue = monthlyRevenue;
    }

    public void enterInfor(Scanner scanner){
        System.out.println("Nhập tên công ty: ");
        nameCompany = scanner.nextLine();
        System.out.println("Nhập mã số thuế:");
        taxCode = scanner.nextLine();
    }
    @Override
    public String toString() {
        return "Company{" +
                "nameCompany='" + nameCompany + '\'' +
                ", taxCode='" + taxCode;
    }
    public void displayEmployees() {
        employeeResourceManager.displayEmployee();
    }
}

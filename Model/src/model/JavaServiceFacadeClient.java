package model;

import java.util.List;

public class JavaServiceFacadeClient {
    public static void main(String[] args) {
        try {
            final JavaServiceFacade javaServiceFacade = new JavaServiceFacade();
            for (Department department : (List<Department>) javaServiceFacade.getDepartmentFindAll()) {
                printDepartment(department);
            }
            for (Employee employee : (List<Employee>) javaServiceFacade.getEmployeeFindAll()) {
                printEmployee(employee);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printDepartment(Department department) {
        System.out.println("departmentId = " + department.getDepartmentId());
        System.out.println("departmentName = " + department.getDepartmentName());
        System.out.println("locationId = " + department.getLocationId());
        System.out.println("employeeList = " + department.getEmployeeList());
        System.out.println("employee = " + department.getEmployee());
    }

    private static void printEmployee(Employee employee) {
        System.out.println("commissionPct = " + employee.getCommissionPct());
        System.out.println("email = " + employee.getEmail());
        System.out.println("employeeId = " + employee.getEmployeeId());
        System.out.println("firstName = " + employee.getFirstName());
        System.out.println("hireDate = " + employee.getHireDate());
        System.out.println("jobId = " + employee.getJobId());
        System.out.println("lastName = " + employee.getLastName());
        System.out.println("phoneNumber = " + employee.getPhoneNumber());
        System.out.println("salary = " + employee.getSalary());
        System.out.println("department = " + employee.getDepartment());
        System.out.println("departmentList = " + employee.getDepartmentList());
        System.out.println("employee1 = " + employee.getEmployee1());
        System.out.println("employeeList1 = " + employee.getEmployeeList1());
    }
}

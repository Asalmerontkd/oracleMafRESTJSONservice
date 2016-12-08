package model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Department.findAll", query = "select o from Department o") })
@Table(name = "DEPARTMENTS")
public class Department implements Serializable {
    private static final long serialVersionUID = 8576443197800585073L;
    @Id
    @Column(name = "DEPARTMENT_ID", nullable = false)
    private Integer departmentId;
    @Column(name = "DEPARTMENT_NAME", nullable = false, length = 30)
    private String departmentName;
    @Column(name = "LOCATION_ID")
    private Integer locationId;
    @OneToMany(mappedBy = "department", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Employee> employeeList;
    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee employee;

    public Department() {
    }

    public Department(Integer departmentId, String departmentName, Integer locationId, Employee employee) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.locationId = locationId;
        this.employee = employee;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }


    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee addEmployee(Employee employee) {
        getEmployeeList().add(employee);
        employee.setDepartment(this);
        return employee;
    }

    public Employee removeEmployee(Employee employee) {
        getEmployeeList().remove(employee);
        employee.setDepartment(null);
        return employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

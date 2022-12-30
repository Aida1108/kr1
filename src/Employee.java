import java.util.Objects;

public class Employee {
    private String lastName;
    private String name;
    private String middleName;
    private String department;
    private double salary;
    private final long id = count;
    private static long count = 1L;



    public Employee(String lastname, String name, String middleName, String department, double salary){
        this.lastName = lastname;
        this.name = name;
        this.middleName = middleName;
        if (Utilit.isDepartment(department)){
            this.department = department;
        } else {
            System.out.println("Данного отдела  не существует");
        }
        this.salary = salary;
        count++;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Сотрудник №" + id + ", ФИО: " + lastName + " " + name + " " + middleName + "отдел: "
                + department + ", зарплата: " + String.format("%.2f", salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

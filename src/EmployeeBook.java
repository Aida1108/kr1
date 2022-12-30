import java.util.ArrayList;
import java.util.List;

public class EmployeeBook {
    private static Employee[] employees = new Employee[10];
    {
        employees[0] = new Employee("Петров", "Иван", "Иванович", "1", 60000);
        employees[1] = new Employee("Иванов", "Кирилл", "Андреевич", "2", 50000);
        employees[2] = new Employee("Сидоров", "Игорь", "Михайлович", "3", 40000);
    }

    /**
     * Добавление сотрудника в массив.
     * @param employee
     */
    public void addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return;
            }
        }
        System.out.println("Нет свободных мест");
    }

    /**
     * Удаление сотрудника с нужными ФИО.
     * @param lastName
     * @param name
     * @param middleName
     */
    public void removeEmployee(String lastName, String name, String middleName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && name.equals(employees[i].getName())
                    && lastName.equals(employees[i].getLastName())
                    && middleName.equals(employees[i].getMiddleName())) {
                employees[i] = null;
                return;
            }
        }
        System.out.println("Сотрудника с таким ФИО не существует");
    }

    /**
     * Вывод списка всех сотрудников.
     */
    public void printAllEmployee(){
        for (Employee employee : employees){
            System.out.println(employee);
        }
    }

    /**
     * Нахождение суммы зарплат всех сотрудников.
     * @return
     */
    public double sumSalary() {
        double sum = 0d;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    /**
     * Выведение суммы зарплат всех сотрудников.
     */
    public void printSumSalary() {
        System.out.println(sumSalary());
    }

    public int getFirstNotNullSalaryIndex() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                return i;
            }
        }
        throw new RuntimeException("Нет ни одного сотрудника");
    }

    /**
     * Нахождение сотрудника с минимальной зарплатой.
     * @return
     */
    public Employee getEmployeeWithMinSalary(){
        Employee employeeWithMinSalary = employees[getFirstNotNullSalaryIndex()];
        for (int i= getFirstNotNullSalaryIndex() + 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employees[i];
            }
        }
        return employeeWithMinSalary;
    }

    /**
     * Нахождение сотрудника с максимальной зарплатой.
     * @return
     */
    public Employee getEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = employees[getFirstNotNullSalaryIndex()];
        for (int i = getFirstNotNullSalaryIndex() + 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employees[i];
            }
        }
        return employeeWithMaxSalary;
    }
    public void printAllEmployeeByDepartment(String department) {
        for (Employee employee : employees){
            if (employee != null && department.equals(employee.getDepartment())){
                System.out.println(employee);
            }
        }
    }
    public void printAllEmployeeGroupDepartment(){
        List<String> departments = findAllDepartment();
        for (String department : departments) {
            System.out.println("В отделе №" + department + "работают следущие сотрудники:");
            printAllEmployeeByDepartment(department);
        }
    }
    public List<String> findAllDepartment() {
        List<String> allDepartment = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee != null && !allDepartment.contains(employee.getDepartment())){
                allDepartment.add(employee.getDepartment());
            }
        }
        return allDepartment;
    }
}

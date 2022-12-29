public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee(new Employee("Романов", "Дмитрий", "Иванович", "3", 40000));
        employeeBook.printAllEmployee();
        employeeBook.printSumSalary();
        System.out.println(("Максимальная зарплата у сотрудника: " + employeeBook.getEmployeeWithMaxSalary()));
        System.out.println(("Минимальная зарплата у сотрудника: " + employeeBook.getEmployeeWithMinSalary()));
        employeeBook.printAllEmployeeGroupDepartment();
    }
}
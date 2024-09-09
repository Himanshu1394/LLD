public class EmpTableImpl implements EmployeeTableDao {

    public void create(String client, String empName) throws Exception{

        System.out.println(empName+" entry has been added to the Employee table");
    }

    public void delete(String client, int empId) throws Exception{

        System.out.println(empId+" has been deleted");
    }

    public void update(String client, int empId) throws Exception{
        System.out.println(empId+" has been updated");
    }

    public Employee get(String client, int empId) throws Exception{

        System.out.println("Fetching details");
        return new Employee();
    }
}

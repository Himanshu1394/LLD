public interface EmployeeTableDao {

    public void create(String client, String empName) throws Exception;

    public void delete(String client, int empId) throws Exception;

    public void update(String client, int empId) throws Exception;

    public Employee get(String client, int empId) throws Exception;
}

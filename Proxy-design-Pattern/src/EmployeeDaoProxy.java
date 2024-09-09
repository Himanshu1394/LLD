public class EmployeeDaoProxy implements EmployeeTableDao{

    EmployeeTableDao emp;

    EmployeeDaoProxy(){
        this.emp = new EmpTableImpl();
    }
    public void create(String client, String empName) throws Exception{

        if(client.equals("Admin")){
            emp.create(client, empName);
            return;
        }

        throw new Exception("Access");
    }

    public void delete(String client, int empId) throws Exception{

        if(client.equals("Admin")){
            emp.delete(client, empId);
            return;
        }

        throw new Exception("Access denied");
    }

    public void update(String client, int empId) throws Exception{

        if(client.equals("Admin")){
            emp.update(client, empId);
            return;
        }

        throw new Exception("Access denied");
    }

    public Employee get(String client, int empId) throws Exception{

        if(client.equals("Admin") || client.equals("User")){
            return emp.get(client, empId);
        }

        throw new Exception("Access denied");
    }

}

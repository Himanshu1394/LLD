//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EmployeeTableDao emp = new EmployeeDaoProxy();
        try {
            emp.create("Admin", "himanshu");
            emp.delete("Admin", 1);
            emp.update("Admin", 1);
            emp.create("Admin", "Shruti");
            emp.get("User", 1);

        }

        catch (Exception e){
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }

    }
}
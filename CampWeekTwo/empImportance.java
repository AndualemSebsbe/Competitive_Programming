import java.util.HashMap;
import java.util.List;

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

public class empImportance {
    int imp = 0;
    public int getImportance(List<Employee> employees, int id) {
         HashMap<Integer, Employee> emap = new HashMap<Integer, Employee>();
         for(Employee emp : employees)
         emap.put(emp.id, emap.getOrDefault(emp.id, emp));
         for(Employee emp : employees){
             if(emp.id == id){
                 imp += emp.importance;
                  for(int sid : emp.subordinates){
                     Employee emp1 = emap.get(sid);
                     // imp += emp1.importance;
                     getImportance(employees, emp1.id);
                  }
             }
         }
        return imp;
    }
}
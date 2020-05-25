package Advanced.OOP.Lect1_WorkingWithAbstraction.Demo;

import java.util.List;

public class School {
    List<String> names;

    public School(List<String> names) {
        this.names = names;
    }

    public boolean over18Years(int age){
        if(age >= 18){
            return true;
        }
        return false;
    }
}

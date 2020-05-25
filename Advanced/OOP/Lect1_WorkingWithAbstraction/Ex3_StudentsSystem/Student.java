package Advanced.OOP.Lect1_WorkingWithAbstraction.Ex3_StudentsSystem;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    private String getDescription() {
        String result = "Very nice person.";

        if (this.getGrade() >= 5.00) {
            result = "Excellent student.";
        } else if (this.getGrade() < 5.00 && this.getGrade() >= 3.50) {
            result = "Average student.";
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s is %s years old. %s", this.getName(), this.getAge(), this.getDescription());

    }
}
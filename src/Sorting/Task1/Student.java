package Sorting.Task1;

public class Student {
    private String name;
    private int group;
    private double averageGrade;

    public Student(String name, int group, double averageGrade) {
        this.name = name;
        this.group = group;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group=" + group +
                ", averageGrade=" + averageGrade +
                '}';
    }
}

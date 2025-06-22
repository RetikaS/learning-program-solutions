public class Student {
    private String name;
    private String id;
    private String grade;
    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
    public String getName() { return name; }
    public String getId() { return id; }
    public String getGrade() { return grade; }
    public void setName(String name) { this.name = name; }
    public void setGrade(String grade) { this.grade = grade; }
}
public class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("Student: ");
        System.out.println("Name: " + student.getName());
        System.out.println("ID: " + student.getId());
        System.out.println("Grade: " + student.getGrade());
    }
}
public class StudentController {
    private Student model;
    private StudentView view;
    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }
    public void updateView() {
        view.displayStudentDetails(model);
    }
    public void setStudentName(String name) {
        model.setName(name);
    }
    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }
}
public class Main {
    public static void main(String[] args) {
        Student student = new Student("Alice", "101", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("Bob");
        controller.setStudentGrade("B");
        controller.updateView();
    }
}
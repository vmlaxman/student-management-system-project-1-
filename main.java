import java.util.Scanner;

public class main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        studentmanage manager = new studentmanage();
        manager.loadFromFile(); // old data load panna ith

  while (true) {

            System.out.println("\nstudent management system");
             System.out.println("\n1 adding student");
            System.out.println("\n2 loading students");
            System.out.println("\n3 updating student");
            System.out.println("\n4 deleting student");
            System.out.println("\n5 exit");

            System.out.print("\n enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("enter id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("enter name: ");
                    String name = sc.nextLine();

                    System.out.print("enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("enter you rcourse: ");
                    String course = sc.nextLine();

                    student s = new student(id, name, age, course);
                    manager.addStudent(s);
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("enter student id: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("enter new age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("enter new course: ");
                    String newCourse = sc.nextLine();
                    manager.updateStudent(updateId, newName, newAge, newCourse);
                    break;

                case 4:
                    System.out.print("enter student id: ");
                    int deleteId = sc.nextInt();
                    manager.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.println("thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("invalid choice!");
            }
        }
    }
}
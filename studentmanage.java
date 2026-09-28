import java.io.*;
import java.util.ArrayList;

public class studentmanage {
    private ArrayList<student> students = new ArrayList<>();
    private final String FILE_NAME = "students.txt";


       // student add pandrathu
    public void addStudent(student s) {
        students.add(s);
        saveToFile();
        System.out.println("student added succes");
    }


    //student view pandrathu
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("it is empty ");
            return;
        }

        for (student s : students) {
            System.out.println(s);
        }
    }

        // student update pandrathu
    public void updateStudent(int id, String name, int age, String course) {
        for (student s : students) {
            if (s.getId() == id) 
            {
                s.setName(name); s.setAge(age);s.setCourse(course);saveToFile();
              System.out.println("student updated success");
                return;
            }
        }
        System.out.println("student is not found");
    }

    public void deleteStudent(int id) {//student delete pandrathu
        for (student s : students) 
        {
            if (s.getId() == id) 
            {
                students.remove(s);
                saveToFile();
                System.out.println("student data deleted success");
                return;
            }
            else 
            {
                System.out.println("student is not found");
            }
        }
        
    }

    private void saveToFile() {//file la save pandrathu
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            for (student s : students) {
                writer.write(
                    s.getId() + "," +
                    s.getName() + "," +
                    s.getAge() + "," +
                    s.getCourse() + "\n"
                );
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("error saving data");
        }
    }

    // file la irunthu data load pandrathu
    public void loadFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) 
            {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];
                student s = new student(id, name, age, course);
                students.add(s);
            }

            reader.close();
        } catch (IOException e) 
        {
            System.out.println("no dataa is here");
        }
    }
}
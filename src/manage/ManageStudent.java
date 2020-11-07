package manage;

import file.FileStudent;
import file.SortStudentByGPA;
import file.SortStudentByID;
import file.SortStudentByName;
import love.Student;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManageStudent {

    Scanner scanner = new Scanner(System.in);
    private List<Student> studentList;
    public FileStudent fileStudent;

    public ManageStudent() {
        fileStudent = new FileStudent();
        studentList = fileStudent.read();
    }

public void add() {
    if(studentList==null){
        studentList=new ArrayList<>();
    }
    int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
    System.out.println("student id = " + id);
    String name = inputName();
    byte age = inputAge();
    String address = inputAddress();
    Student student = new Student(id, name, age, address,0,0,0);
    studentList.add(student);
    fileStudent.write(studentList);
}



    public void edit() {
        System.out.print("Enter the ID to edit :");
        int id=Integer.parseInt(scanner.nextLine());
        boolean isExisted = false;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                isExisted = true;
                studentList.get(i).setName(inputName());
                studentList.get(i).setAge(inputAge());
                studentList.get(i).setAddress(inputAddress());
                studentList.get(i).setScoreLiter(0);
                studentList.get(i).setScoreMath(0);
                studentList.get(i).setScoreGPA(0);

                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            fileStudent.write(studentList);
        }
    }


    public void delete() {
        System.out.print("Enter the ID to delete :");
        int id=Integer.parseInt(scanner.nextLine());
        Student student = null;
        int size = studentList.size();
        int index=0;
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                student = studentList.get(i);
                index=i;
                break;
            }
        }
        if (student != null) {
            studentList.remove(student);
            for (int i = index; i < size-1; i++) {
                int id1=studentList.get(i).getId();
                studentList.get(i).setId(id1-1);
            }
            fileStudent.write(studentList);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }


    public void sortStudentByName() {
        try{
            Collections.sort(studentList, new SortStudentByName());
        }catch (Exception e){
            System.out.println("The list is empty !!!! (>.<)");
        }

    }


    public void sortStudentByGPA() {
        try{
            Collections.sort(studentList, new SortStudentByGPA());
        }catch (Exception e){
            System.out.println("The list is empty !!!! (>.<)");
        }

    }

    public void sortStudentByID(){
        try{
            Collections.sort(studentList,new SortStudentByID());
        }catch (Exception e){
            System.out.println("The list is empty !!!! (>.<)");
        }
    }



    public void show() {
        try{
            for (Student student : studentList) {
                System.out.format("%5d | ", student.getId());
                System.out.format("%20s | ", student.getName());
                System.out.format("%5d | ", student.getAge());
                System.out.format("%10s | ", student.getAddress());
                System.out.format("%10s | ", student.getScoreMath());
                System.out.format("%10s | ", student.getScoreLiter());
                System.out.format("%10.1f%n", student.getScoreGPA());
            }
        }catch (Exception e){
            System.out.println("The list is empty !!!! (>.<)");
        }

    }




    public float caculatorGPA(float score1, float score2){
        return (score1+score2)/2;
    }

    public void updateScore(){
        System.out.print("Enter the ID to update :");
        int id=Integer.parseInt(scanner.nextLine());
        if(studentList==null){
            System.out.println("The list is empty !!!! (>.<)");
        }else {
            boolean isExisted = false;
            for (Student stu : studentList) {
                if (stu.getId() == id) {
                    isExisted=true;

                    System.out.print("Enter Score Math : ");
                    float scoreMath=inputScore();
                    stu.setScoreMath(scoreMath);

                    System.out.print("Enter Score Literature: ");
                    float scoreLiter=inputScore();
                    stu.setScoreLiter(scoreLiter);

                    stu.setScoreGPA(caculatorGPA(scoreMath,scoreLiter));
                }
            }
            if (!isExisted) {
                System.out.printf("id = %d not existed.\n", id);
            } else {
                System.out.println("Update successfully!!!!!!");
                fileStudent.write(studentList);
            }
        }
    }



    private float inputScore() {
        boolean check;
        float score = 0;
        do {
            try {
                check = false;
                score = Float.parseFloat(scanner.nextLine());
            } catch (Exception e) {
                check = true;
            }
        } while (check);
        return score;
    }


    private String inputName() {
        String regex="[A-Z][a-zA-Z, ]+";
        String name;
        boolean check;
        do{
            System.out.print("Input student name (Viet hoa chu dau tien): ");
            name=scanner.nextLine();
            check=isMatch(regex,name);
        }while (!check);
        return name;
    }


    private String inputAddress() {
        System.out.print("Input student address: ");
        return scanner.nextLine();
    }

    private byte inputAge() {
        byte age;
        System.out.print("Input student age: ");
        while (true) {
            try {
                age = Byte.parseByte((scanner.nextLine()));
                if (age < 10 || age > 100) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }

    public static boolean isMatch(String rg, String temp){
        String regex = rg;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(temp);
        return matcher.matches();
    }

}

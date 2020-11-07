import manage.ManageStudent;
import user.UserStudent;
import user.UserTeach2;
import user.UserTeacher1;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static UserTeacher1 userTeacher1=new UserTeacher1();
    public static UserTeach2 userTeacher2=new UserTeach2();
    public static UserStudent userStudent = new UserStudent();
    public static ManageStudent manageStudent =new ManageStudent();

    public static void main(String[] args) {
        String choice;
        Menu menus=new Menu();

        do{
            boolean check;
            do{
                menus.menu();
                choice= scanner.nextLine();
                String regex="[1-3]";
                check= ManageStudent.isMatch(regex,choice);
            }while (!check);
            switch (choice){
                case "1":

                    System.out.println("Login User of Student ");
                    boolean check1=login(userStudent.getUSER(),userStudent.getPASS());
                    if(check1){
                        boolean check2;
                        do{
                            check2=true;
                            menus.showMenu1();
                            String choice1=scanner.nextLine();
                            if(choice1.equals("1")) {
                                manageStudent.show();
                            }else
                            if(choice1.equals("2")) {
                                manageStudent.sortStudentByGPA();
                            }else
                            if(choice1.equals("3")) {
                                manageStudent.sortStudentByName();
                            }else
                            if(choice1.equals("4")){
                                manageStudent.sortStudentByID();
                            }else
                            if(choice1.equals("0")) {
                                check2 = false;
                                System.out.println("***************  LOG OUT  **************");
                            }
                            else {
                                System.out.println("Does not have this function!!!!!! (>.<)");
                            }
                        }while (check2);

                    }else {
                        break;
                    }
                    break;
                case "2":

                    System.out.println("Login User of Teacher1.");
                    boolean check2=login(userTeacher1.getUSER(),userTeacher1.getPASS());
                    if(check2){
                        boolean check3;
                        do{
                            check3=true;
                            menus.showMenu2();
                            String choice2= scanner.nextLine();
                            if(choice2.equals("1")) {
                                manageStudent.add();
                            }else
                            if(choice2.equals("2")) {
                                manageStudent.edit();
                            }else
                            if(choice2.equals("3")) {
                                manageStudent.delete();
                            }else
                            if(choice2.equals("4")){
                                manageStudent.sortStudentByGPA();
                            }else
                            if(choice2.equals("5")){
                                 manageStudent.sortStudentByName();
                            }else
                            if(choice2.equals("6")){
                                 manageStudent.sortStudentByID();
                            }else
                            if(choice2.equals("7")){
                                 manageStudent.show();
                            }
                            else
                            if(choice2.equals("0")) {
                                check3 = false;
                                System.out.println("***************  LOG OUT  **************");
                            }else {
                                System.out.println("Does not have this function!!!!!! (>.<)");
                            }

                        }while (check3);
                    }else {
                        break;
                    }
                    break;
                case "3":

                    System.out.println("Login User of Teacher2.");
                    boolean check3=login(userTeacher2.getUSER(),userTeacher2.getPASS());
                    if(check3){
                        boolean check4;
                        do{
                            check4=true;
                            menus.showMenu3();
                            String choice3= scanner.nextLine();
                            if(choice3.equals("1")){
                                manageStudent.updateScore();
                            }else
                                if(choice3.equals("2")){
                                    manageStudent.show();
                                } else
                                    if(choice3.equals("3")){
                                        manageStudent.sortStudentByGPA();
                                    }else
                                        if(choice3.equals("4")){
                                            manageStudent.sortStudentByName();
                                        }else
                                            if(choice3.equals("5")){
                                                manageStudent.sortStudentByID();
                                            }else
                                                if(choice3.equals("0")){
                                                    check4=false;
                                                    System.out.println("***************  LOG OUT  **************");
                                                }else {
                                                    System.out.println("Does not have this function!!!!!!!!!!! (>.<)");
                                                }
                        }while (check4);

                    }else {
                        break;
                    }
                    break;
            }
        }while (true);

    }


    public static boolean loginUserPass(String temp) {
        String user1 = scanner.nextLine();
        return temp.equals(user1);
    }


    public static boolean login(String user,String pass) {
        boolean check = true;
        for (int i = 0; i < 3; i++) {
            System.out.print("Username : ");
            check = loginUserPass(user);
            if (!check) {
                System.out.println("Username false (>.<)");
            } else {
                break;
            }

        }
        if (check) {

            for (int i = 0; i < 3; i++) {
                System.out.print("Pass :");
                check = loginUserPass(pass);
                if (!check) {
                    System.out.println("Password (>.<)");
                } else {
                    break;
                }
            }
        }
        if (check) {
            System.out.println("Logged in successfully!!!!!!!!!!! ^.^");
        } else {
            System.out.println("Login failed!!!!!!!!!!!!!!!!!!!!! >.<");
        }
        return check;
    }

}
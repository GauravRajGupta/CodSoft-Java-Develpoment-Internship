import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.TreeSet;

class InvalidOperation extends Exception{
    public String getMessages(){
        return "INVALID OPERATION PERFORMED ! (Try Again.)";
    }
}

public class _5StudentManagementSystem{
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InputMismatchException {
        System.out.println("********************WELCOME TO STUDENT MANAGEMENT SYSTEM !********************");

        ManagementSystem mmSys = new ManagementSystem();
        InvalidOperation inv = new InvalidOperation();
        boolean enter = true;

        while(enter){
            System.out.println("\nOperations to be performed (1, 2, 3, 4 or 5) :-\n1) ADD STUDENT\n2) DELETE STUDENT\n3) SEARCH STUDENT\n4) GET ALL STUDENT DETAILS\n5)EXIT");
            int option = sc.nextInt();

            switch (option){
                case 1:
                    try{
                        System.out.print("Enter the name of the student : ");
                        String name = sc.next();
                        System.out.print("Enter the roll no. of the student : ");
                        int rollNo = sc.nextInt();
                        System.out.print("Enter the gender of the student : ");
                        String gender = sc.next();
                        System.out.print("Enter the grade of the student : ");
                        String grade = sc.next();
                        Student s = new Student(name, rollNo, gender, grade);
                        mmSys.addStudent(s);
                        System.out.print("Student Added !");
                    } catch (InputMismatchException e){
                        System.err.println(inv.getMessages());
                    } catch (Exception e){
                        System.err.println(inv.getMessages());
                    }
                    break;
                case 2:
                    try{
                        System.out.print("Enter the roll no. of the student to delete : ");
                        int delete = sc.nextInt();
                        System.out.println(mmSys.removeStudent(delete));
                    } catch (Exception e){
                        System.err.println(inv.getMessages());
                    }
                    break;
                case 3:
                    System.out.print("Enter the roll no. of the student to search : ");
                    int search = sc.nextInt();
                    Student s = mmSys.searchStudent(search);
                    if(s != null){
                        System.out.println(s.toString());
                    }
                    else{
                        System.out.println("Student not found !");
                    }
                    break;
                case 4:
                    System.out.println("**************************************************");
                    mmSys.allStudent();
                    break;
                case 5:
                    enter = false;
                    break;
                default:
                    System.err.println(inv.getMessages());
            }
        }

    }
}



class ManagementSystem {
    private TreeSet<Student> student;

    public ManagementSystem(){
        student = new TreeSet<Student>();
    }
    public void addStudent(Student stu) throws InvalidOperation{
        if(stu.getName() != null || stu.getGender() != null || stu.getGrade() != null){
            student.add(stu);
        }
        else{
            InvalidOperation inv = new InvalidOperation();
            System.out.println(inv.getMessages());
            throw inv;
        }
    }

    public String removeStudent(int id){
        Student delStudent = null;
        for(Student stu : student){
            if(stu.getRollNo() == id){
                delStudent = stu;
                break;
            }
        }
        if(delStudent != null){
            student.remove((delStudent));
            return delStudent.getName()+" with Roll No. "+delStudent.getRollNo()+" is deleted !";
        }
        return "Student not found !";
    }

    public Student searchStudent(int id){
        for(Student stu : student){
            if(stu.getRollNo() == id){
                return stu;
            }
        }
        return null;
    }

    public void allStudent(){
        for(Student stu : student){
            System.out.println(stu.toString());
        }
    }

}



class Student implements Comparable<Student> {
    private String name;
    private int rollNo;
    private String grade;
    private String gender;

    public String getName(){
        return name;
    }
    public int getRollNo(){
        return rollNo;
    }
    public String getGrade(){
        return grade;
    }
    public String getGender(){
        return gender;
    }
    public void setName(String name){
        this.name  = name;
    }
    public void setRollNo(int rollNo){
        this.rollNo = rollNo;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public Student(String name, int rollNo, String gender, String grade){
        this.name = name;
        this.rollNo = rollNo;
        this.gender = gender;
        this.grade = grade;
    }

    public String toString(){
        return "Name : "+name+" || Roll No. : "+rollNo+" || Grade : "+grade+" || Gender : "+gender;
    }

    public int compareTo(Student o){
        return Integer.compare(this.rollNo, o.rollNo);
    }

    public Student(){
        super();
    }

}
import java.util.*;

public class _2StudentGradeCalculator{
    public static void main(String[] args){
        int sub1, sub2, sub3, sub4, sub5, totalMarks, noOfSub=5;
        double avgPercentage;
        char grade;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the marks obtained in each subject (out of 100) !");

        System.out.print("Java : ");
        sub1 = sc.nextInt();
        System.out.print("Data Structure : ");
        sub2 = sc.nextInt();
        System.out.print("Cyber Security : ");
        sub3 = sc.nextInt();
        System.out.print("Discrete Mathematics :");
        sub4 = sc.nextInt();
        System.out.print("Computer Organization : ");
        sub5 = sc.nextInt();

        totalMarks = sub1 + sub2 + sub3 + sub4 + sub5;
        avgPercentage = (double) totalMarks / noOfSub;

        if(avgPercentage >= 90){
            grade = 'A';
        }
        else if(avgPercentage >= 80){
            grade = 'B';
        }
        else if(avgPercentage >= 70){
            grade = 'C';
        }
        else if(avgPercentage >= 50){
            grade = 'D';
        }
        else{
            grade = 'E';
        }

        System.out.print("\n********************RESULTS !********************\n\n");
        System.out.println("Total Marks : "+totalMarks);
        System.out.println("Average % : "+avgPercentage);
        System.out.println("Grade : "+grade);
        System.out.print("\n*************************************************\n");

    }
}
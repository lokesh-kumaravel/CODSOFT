import java.util.*;
public class Studentgradecalculator
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("               ****************WELCOME TO GRADE CALCULATOR****************    ");
        System.out.print("Enter Total no of Subjects:");
        int totalSubjects = scan.nextInt();
        int[] subjectMarks = new int[totalSubjects];
        double totalMarks = 0;
        int c=1,Fail= 0 ;
        System.out.println("Enter Marks out of 100");
        for(int i=0;i<totalSubjects;i++)
        {
            System.out.print("Enter Subject Mark "+c+":");
            subjectMarks[i] = scan.nextInt();
            totalMarks+=subjectMarks[i];
            if(subjectMarks[i]<50)
            {
                Fail++;
            }
            c++;
        }
        double Average = totalMarks / totalSubjects;
        char Grade;
        if (Average >= 90) {
           Grade = 'O';
        } else if (Average >= 80) {
           Grade = 'A';
        } else if (Average >= 70) {
           Grade = 'B';
        } else if (Average >= 60) {
           Grade = 'C';
        }else if (Average >= 50) {
           Grade = 'D';
        }else {
           Grade = 'F';
        }
        System.out.println("Total Marks : "+totalMarks+"/"+""+totalSubjects*100);
        System.out.println("Average Percentage Obtained for 100: "+Average+"%");
        if(Grade != 'F' && Fail == 0)
        {
        System.out.println("Your Grade is : "+Grade);
        }
        else if(Fail>0)
        {
            System.out.println("Your Grade is FAIL ");
            System.out.println("You are Fail in "+Fail+" Subject");
        }
        scan.close();
    }
}
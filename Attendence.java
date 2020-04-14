/*
created by Abilash kb
Topic:Online Attendence Management System
*/
import java.io.*;
import java.util.*;               
import java.text.DateFormat;
import java.text.SimpleDateFormat;
class subject /*class which name is subject*/
{
    int sem;
    String branch;
    Scanner sc=new Scanner(System.in);
    void read() throws IOException
    {
        System.out.println("which branch:");
        branch=sc.next();                    /*Get the branch & semester*/
        System.out.println("which semester:");
        sem=sc.nextInt();
        
    }

}
class enter extends subject /*class enter is take the attendence details and write in their respective files*/
{
    int n;
    String sub;
    Scanner sc=new Scanner(System.in);
    void read()throws IOException
    {
        super.read();
        System.out.println("Enter your subject:");
        sub=sc.next();
        System.out.println("Enter the no.of Students present:");
        n=sc.nextInt();
        int roll[]=new int[n];
        System.out.println("Enter the Student's roll_numbers:");
        for(int i=0; i<n;i++){
            roll[i]=sc.nextInt();
        }
        try                               /*File write process in try-catch block*/
        {
            Date date = new Date();// for date and time
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

            String strDate = dateFormat.format(date);
            String strTime = timeFormat.format(date);

            System.out.println("Date = " + strDate);
            System.out.println("Time = " + strTime);
        
            int len = roll.length;
            File out = new File(branch+sem+".txt");
            if(out.exists()== false)
            {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(branch+sem+".txt"));
                bufferedWriter.write(strDate +"\t"+ strTime+"\n");
                bufferedWriter.newLine();
                bufferedWriter.write("BRANCH:"+branch+"\n");
                bufferedWriter.write("SEMESTER:"+sem+"\n");
                bufferedWriter.write("SUBJECT:"+sub+"\n");
                bufferedWriter.write("Student which present:"+"\n");
                for (int i = 0; i < len; i++) {
                    bufferedWriter.write(roll[i] + "\t"+ "");
                }
                bufferedWriter.newLine();
                bufferedWriter.write("****************************************************"+"\n");
                bufferedWriter.close();
            }
            else
            {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(branch+sem+".txt", true));
                bufferedWriter.newLine();   //Add new line
                bufferedWriter.write(strDate +"\t"+ strTime+"\n");
                bufferedWriter.write("BRANCH:"+branch+"\n");
                bufferedWriter.write("SEMESTER:"+sem+"\n");
                bufferedWriter.write("SUBJECT:"+sub+"\n");
                bufferedWriter.write("Student which present:"+"\n");
                for (int i = 0; i < len; i++) {
                    bufferedWriter.write(roll[i] + "\t"+ "");
                }
                bufferedWriter.newLine();
                bufferedWriter.write("****************************************************"+"\n");
                bufferedWriter.close();
            }

            System.out.println("File Written");// file written 
        }
        catch(IOException e) //exception block
        {
            System.out.println("Error: Something went wrong. Please try again");
        }
    }
} 
class take extends subject     /*class take is take and display the respective attendence details*/
{
    void read() throws IOException
    {
        super.read();
        FileReader in = null;
                
        try{
            in=new FileReader(branch+sem+".txt");
            BufferedReader br=new BufferedReader(in);
            String str;
            while((str=br.readLine())!=null){
                System.out.println(str+"\t");
            }
            br.close();
        }
        catch (IOException IOE)
        {
            System.out.println(IOE);
        }
    }
}
class Attendence             /* main class start*/
{
    public static void main(String[] args) throws IOException
    {
        int ch;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("The Operation");      /*Two operation 1 is Enter the attendence in file and 2 is Take the attendence */
            System.out.println("1.Enter the attendence\n2.Take the attendence\n3.Exist");
            ch=sc.nextInt();
            if(ch==1)
            {
                subject s2=new subject();
                enter s3=new enter();
                s2=s3;
                s2.read();
            }
            else if(ch==2)
            {
                subject s4=new subject();
                take s5=new take();
                s4=s5;
                s4.read();
            }
            else if(ch==3)
            {
                break;
            }
        }while(ch<=3); //end while

    }
}

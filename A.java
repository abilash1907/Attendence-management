import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
class subject
{
    int sub;
    Scanner sc=new Scanner(System.in);
    void read() throws IOException
    {
        System.out.println("Enter your subject..............");
        System.out.println("1.OODP\n2.COA\n3.PDD\n4.OS\n5.BE\n6.PDTNM");
        sub=sc.nextInt();
    }

}
class enter extends subject
{
    int n;
    Scanner sc=new Scanner(System.in);
    void read()throws IOException
    {
        super.read();
        System.out.println("Enter the no.of Students present");
        n=sc.nextInt();
        int roll[]=new int[n];
        switch(sub){
            case 1:{
               
                System.out.println("Enter the student'S roll_no whose present in oodp");
                for(int i=0; i<n;i++){
                    roll[i]=sc.nextInt();
                }
                break;
            }
            case 2:{
                
                System.out.println("Enter the student'S roll_no whose present in coa");
                for(int i=0; i<n;i++){
                    roll[i]=sc.nextInt();
                }
                break;
            }
            case 3:{
                
                System.out.println("Enter the student'S roll_no whose present in Pdd");
                for(int i=0; i<n;i++){
                    roll[i]=sc.nextInt();
                }
                break;
            }
            case 4:{
                
                System.out.println("Enter the student'S roll_no whose present in os");
                for(int i=0; i<n;i++){
                    roll[i]=sc.nextInt();
                }break;
            }
            case 5:{
                System.out.println("Enter the no.of Students present");
                n=sc.nextInt();
                System.out.println("Enter the student'S roll_no whose present in BE");
                for(int i=0; i<n;i++){
                    roll[i]=sc.nextInt();
                }break;
            }
            case 6:{
                
                System.out.println("Enter the student'S roll_no whose present in pdtnm");
                for(int i=0; i<n;i++){
                    roll[i]=sc.nextInt();
                }break;
            }
            default:{System.out.println("Invalid choice");}
        }
        try
        {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

            String strDate = dateFormat.format(date);
            String strTime = timeFormat.format(date);

            System.out.println("Date = " + strDate);
            System.out.println("Time = " + strTime);
        
            int len = roll.length;
            File out = new File(sub+".txt");
            if(out.exists()== false)
            {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(sub+".txt"));
                bufferedWriter.write(strDate +"\t"+ strTime+"\n");
                for (int i = 0; i < len; i++) {
                    bufferedWriter.write(roll[i] + "\t"+ "");
                }
                bufferedWriter.close();
            }
            else
            {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(sub+".txt", true));
                bufferedWriter.newLine();   //Add new line
                bufferedWriter.write(strDate +"\t"+ strTime+"\n");
                for (int i = 0; i < len; i++) {
                    bufferedWriter.write(roll[i] + "\t"+ "");
                }
                bufferedWriter.close();
            }

            System.out.println("File Written");
        }
        catch(IOException e)
        {
            System.out.println("Error: Something went wrong. Please try again");
        }
    }
} 
class take extends subject
{
    void read() throws IOException
    {
        super.read();
        FileReader in = null;
                
        try{
            in=new FileReader(sub+".txt");
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
class A
{
    public static void main(String[] args) throws IOException
    {
        int ch;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("The Operation");
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
        }while(ch<=3);

    }
}   
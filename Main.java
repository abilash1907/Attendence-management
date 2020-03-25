import java.io.*;
import java.util.*;

class Main{

   public static void main(String args[])throws IOException{
        int ch,sub,n;
        
        Scanner sc=new Scanner(System.in);
        System.out.println("The Operation");
        System.out.println("1.Take the attendence\n2.Enter the attendence");
        ch=sc.nextInt();
        System.out.println("Enter your subject..............");
        System.out.println("1.OODP\n2.COA\n3.PDD\n4.OS\n5.BE\n6.PDTNM");
        sub=sc.nextInt();
        
        System.out.println("Enter the no.of Students present");
        n=sc.nextInt();
        int roll[]=new int[200];
        
        switch(ch){
            case 1:{
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
                break;


            }
            case 2:{
                
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
                    
                    
                        
                }
                FileWriter out = new FileWriter(sub+".txt");
                
                int len = roll.length;
                try{
                    for (int i = 0; i < len; i++) {
                        out.write(roll[i] + "\t"+ "");
                    }
                    out.close();
                }
                catch (IOException IOE)
                {
                    System.out.println(IOE);
                }
                break;
                        
                    
                     

            }
        }
    }
}
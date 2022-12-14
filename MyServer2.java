import java.util.*; 
import java.net.*;  
import java.io.*;  
public class MyServer2 {
     
   
    public static void main(String args[])throws Exception{  
        ServerSocket ss=new ServerSocket(4444);  
        Socket s=ss.accept();  
        DataInputStream din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
          
        String str="",str2="";  
        while(!str.equals("stop")){  
        str=din.readUTF();  
        int len = str.length();
        
        String dec = "";
        if((str.charAt(0)=='1')&& (str.charAt(1)=='0')){
            dec = dec.concat("1");
        }
        else{
            dec = dec.concat("0");
        }
        for (int i = 2; i < len; i+=2)
        {
               if((str.charAt(i-1)=='0' && str.charAt(i)=='1') || (str.charAt(i-1)=='1' &&str.charAt(i)=='0')){
                dec = dec + "0";
               }
               else if((str.charAt(i-1)=='0' && str.charAt(i)=='0')|| (str.charAt(i-1)=='1' && str.charAt(i)=='1')){
                dec = dec + "1";
               }
            
        }
       // System.out.println(dec);
        System.out.println("client says: "+dec);  
        // str2=br.readLine();  
        // int length = str2.length();
        // String enc = "";
        // char e=str2.charAt(0);
        // for (int i = 0; i < length; i++)
        // {
        //     if ((str2.charAt(i))=='0'){
        //         if(e=='0'){
        //         enc = enc + "10";
        //         e='0';
        //         }
        //         else{
        //             enc = enc + "01";
        //             e='1';
        //         }
                
        //     }
        //    else{
        //     if(e=='0'){
        //         enc = enc + "01";
        //         e='1';
        //     }
        //     else{
        //         enc = enc + "10";
        //         e = '0';
        //     }
        //    }

        // }
        // dout.writeUTF(enc);  
        // //dout.flush();  
         }  
        din.close();  
        s.close();  
        ss.close();  
        }
   
}

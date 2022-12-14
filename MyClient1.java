import java.net.*;  //Manchester 
import java.io.*;  
public class MyClient1 {
    public static void main(String args[])throws Exception{  
        Socket s=new Socket("localhost",2222);  
        DataInputStream din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
          
        String str="",str2="";  
        while(!str.equals("stop")){  
        
        str=br.readLine();  
        int length = str.length();
        
        String enc = "";
        for (int i = 0; i < length; i++)
        {
            if ((str.charAt(i))=='0'){
                enc = enc + "01";
            }
            
            else {
                enc = enc + "10";
            }
        }
        dout.writeUTF(enc);  
       // dout.flush();  
        str2=din.readUTF(); 
        int len = str2.length();
        
        String dec = "";
        for (int i = 0; i < len; i+=2)
        {
            String substr = str2.substring(i,i+2);
            if (substr.equals("01")){
                dec = dec + "0";
            }
            if(substr.equals("10")){
                dec = dec + "1";
            }
//            System.out.println(substr);
        }
        
        System.out.println("Server says: "+dec);  
        }  
          
        dout.close();  
        s.close(); 
    }
}

import java.net.*;  //Manchester
import java.io.*;  

public class MyServer1 {
    public static void main(String args[])throws Exception{  
        ServerSocket ss=new ServerSocket(2222);  
        Socket s=ss.accept();  
        DataInputStream din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
          
        String str="",str2="";  
        while(!str.equals("stop")){  
        str=din.readUTF();  
        int len = str.length();
        
        String dec = "";
        for (int i = 0; i < len; i+=2)
        {
            String substr = str.substring(i,i+2);
            if (substr.equals("01")){
                dec = dec + "0";
            }
            if(substr.equals("10")){
                dec = dec + "1";
            }
//            System.out.println(substr);
        }
       // System.out.println(dec);
        System.out.println("client says: "+dec);  
        str2=br.readLine();  
        int length = str2.length();
        String enc = "";
        for (int i = 0; i < length; i++)
        {
            if ((str2.charAt(i))=='0'){
                enc = enc + "01";
            }
            
            else {
                enc = enc + "10";
            }
        }
        dout.writeUTF(enc);  
        //dout.flush();  
        }  
        din.close();  
        s.close();  
        ss.close();  
        }
}

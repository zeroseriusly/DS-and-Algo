
import java.net.*;  
import java.io.*;  
public class MyClient2 {
    public static void main(String args[])throws Exception{  
        Socket s=new Socket("localhost",4444);  
        DataInputStream din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
          
        String str="",str2="";  
        while(!str.equals("stop")){  
        
        str=br.readLine();  
        int length = str.length();
        
        String enc = "";
        char e=str.charAt(0);
        for (int i = 0; i < length; i++)
        {
            if ((str.charAt(i))=='0'){
                if(e=='0'){
                enc = enc + "10";
                e='0';
                }
                else{
                    enc = enc + "01";
                    e='1';
                }
                
            }
           else{
            if(e=='0'){
                enc = enc + "01";
                e='1';
            }
            else{
                enc = enc + "10";
                e = '0';
            }
           }
        }
        System.out.println("Encoded String send: "+enc); 
        dout.writeUTF(enc);  
    }
       // dout.flush();  
//         str2=din.readUTF(); 
//         int len = str2.length();
        
//         String dec = "";
//         if((str2.charAt(0)=='1')&& (str2.charAt(1)=='0')){
//             dec = dec.concat("1");
//         }
//         else{
//             dec = dec.concat("0");
//         }
//         for (int i = 2; i < len; i+=2)
//         {
//                if((str2.charAt(i-1)=='0' && str2.charAt(i)=='1') || (str2.charAt(i-1)=='1' &&str2.charAt(i)=='0')){
//                 dec = dec + "0";
//                }
//                else if((str2.charAt(i-1)=='0' && str2.charAt(i)=='0')|| (str2.charAt(i-1)=='1' && str2.charAt(i)=='1')){
//                 dec = dec + "1";
//                }
//             // String substr = str2.substring(i,i+2);
//             // String substr2 = str2.substring(i+2, i+4);
//             // if (substr.equals("01") && substr2.equals("01")){
//             //     dec = dec + "0";
//             // }
//             // if (substr.equals("01") && substr2.equals("10")){
//             //     dec = dec + "0";
//             // }
//             // if(substr.equals("10") && substr2.equals("01")){
//             //     dec = dec + "1";
//             // }
// //            System.out.println(substr);
//         }
        
//         System.out.println("Server says: "+dec);  
//         }  
          
        dout.close();  
        s.close(); 
    }
}

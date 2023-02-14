package sg.edu.nus.iss.app.task01.src;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) throws IOException
    {
        // 

        Socket sock = new Socket("localhost", 5000);

        // preparare input data from server
        InputStream is = sock.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);

        // prepare output data from server
        OutputStream os = sock.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);


        try {
            String recData = "";


          while (true) {
            recData = ois.readUTF();
        
                System.out.println(recData);
                List<Float> numbers = new ArrayList<Float>();
                System.out.println(Float.parseFloat(recData));
                
                for (String f : recData) {
                    numbers.add(Float.parseFloat(f));
                }  
              
                System.out.println(numbers);

            
                // get sum
           Float sum = 0.00f;
            for (Float n : numbers) {
                sum += n;
            }

            // get mean
                Float mean =  sum / numbers.size();
               System.out.println(mean); 

               // Get standard deviation of list of numbers
Double standardDeviation = 0.0;
for (double n: numbers) {
    standardDeviation += Math.pow(n - mean, 2);
}

// send response to server
double sd = Math.sqrt(standardDeviation / numbers.size());
oos.writeUTF("Irene Lee");
oos.writeUTF("irene_lee@live.com.sg");
oos.writeFloat(mean);
oos.writeFloat((float) sd);



//close all streams
oos.close();
os.close();
ois.close();
is.close();
sock.close();
         break;   

            }
          
    } catch (IOException e) {
        e.printStackTrace();
    }



}











}
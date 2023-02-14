package sg.edu.nus.iss.app.task02.src;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class secondApp {
   
    
    
    public static String dirName = "";
    public static String fileName = "cat_in_the_hat.txt";
    public static String dirFileName = dirName + File.separator + fileName;


    public static void main(String[] args) throws IOException {
        
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("kill")) {
                System.out.println("Ending program...");

                System.exit(0);
            }
        }

        if (args[0].equalsIgnoreCase("seuss")){

            String dirName = args[0];

            Path p = Paths.get(dirName, fileName);
            File f = p.toFile();
            System.out.println();
           

        try {
           
                 FileReader fr = new FileReader(f.getAbsolutePath());
                 System.out.println(fr);
                 BufferedReader br = new BufferedReader(fr);
                 String line;
                 List<String> story = new ArrayList<>();
         
                 while ((line = br.readLine()) != null) {
                    line.replace(",", " ");
                    line.replace(".", " ");
                    line.replace(":", " ");
                    line.replace("()", " ");
                    line.replace("{}", "");
                    line.replace("-", "");
                 

                    story.add(line.toLowerCase());
                 }

                 String input = "";

                 Console cons = System.console();

                 while (!input.equalsIgnoreCase("quit")) {
                    input = cons.readLine("Enter the word\n");
                    

                    int wordOccurence = 0;
                    int wordNextOccurence = 0; 

                    // first word index
                    int wordIndex = story.indexOf(input);
                    
                    // second word index
                    int wordNextIndex = wordIndex + 1;

                    // second word
                    String nextWord = story.get(wordNextIndex);


                    for (String w : story) {
                       if (w == input) {
                        wordOccurence++;
                       }
                       if (w == nextWord) {
                        wordNextOccurence++;
                       }
                    }

                    System.out.println(input);
                    System.out.println(nextWord);
                    System.out.println(wordOccurence);
                    System.out.println(wordNextOccurence);
                    
                    System.out.println(story);
                 }
   

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            
            
        }
        }
        
        
    

    



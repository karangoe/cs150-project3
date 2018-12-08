
/**
 * Compares two files with each other
 *
 * @author Elene Karangozishvili
 * @version 11.19.2018
 */
import java.util.*;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.File;
public class CompareOutputs
{

    /**
     * Compares two files passed on to main.
     * prints the number of the line where the files were
     * different and prints what are in the file in that line.
     */
    public static void main(String args[]){
        String file1 = args[0];
        String file2 = args[1];
        boolean same = true;
        try{
            Scanner reader1 = new Scanner(new File(file1));
            Scanner reader2 = new Scanner(new File(file2));
            int line =0;
            while(reader1.hasNextLine() && reader2.hasNextLine()){
                line++;
                String s1 = reader1.nextLine();
                String s2 = reader2.nextLine();
                if(s1.compareTo(s2)!=0){
                    System.out.println("line: "+line);
                    System.out.println("First input: "+s1);
                    System.out.println("Second input: "+s2);
                    same = false;
                }
            }
            if(reader1.hasNextLine()){
                System.out.println("Second file terminates after the line: "+line+", while the first file does not.");
                same = false;
            }
            if(reader2.hasNextLine()){
                System.out.println("First file terminates after the line: "+line+", while the second file does not.");
                same = false;
            }

            if(same) System.out.println("Files are identical");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

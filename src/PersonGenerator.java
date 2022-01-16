import java.util.ArrayList;
import java.util.Scanner;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;

public class PersonGenerator
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
	    ArrayList <String> recs = new ArrayList<>();

        //list values
        String id = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int yearOfBirth;

        //do while loop condition
        boolean check = true;

        System.out.println("Please enter a person(s).");

        do
        {
            id = SafeInput.getNonZeroLenString(in, "Please enter the person's ID");
            firstName = SafeInput.getNonZeroLenString(in, "Please enter the person's firstName");
            lastName = SafeInput.getNonZeroLenString(in, "Please enter the person's lastName");
            title = SafeInput.getNonZeroLenString(in, "Please enter the person's title (Ex: Mr., Mrs., Ms., Dr., etc.)");
            yearOfBirth = SafeInput.getInt(in, "Please enter the person's year of birth");

            recs.add("" + id + ",   " + firstName + ",     " + lastName + ",     " + title + ",   " + yearOfBirth);

            check = SafeInput.getYNConfirm(in, "Do you wish to add another person?");
        } while(check);


        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTextData.txt");

        try
        {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(String rec : recs)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

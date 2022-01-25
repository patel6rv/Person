import java.util.ArrayList;
import java.util.Arrays;
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

public class PersonReader
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec= "";
        ArrayList<Person> personArrayList = new ArrayList<>();


        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while(reader.ready())
                {
                    rec = reader.readLine();
                    String[] lineInArray = rec.split(", ");
                    Person folk = new Person(lineInArray[0], lineInArray[1], lineInArray[2], lineInArray[3], Integer.parseInt(lineInArray[4]));
                    personArrayList.add(folk);
                }
                reader.close();
                System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("=".repeat(90));
                for(Person listedPerson : personArrayList)
                {
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s\n\n", listedPerson.getIDNum(), listedPerson.getFirstName(), listedPerson.getLastName(), listedPerson.getTitle(), listedPerson.getYOB());
                }
                System.out.println("\n\nData file read!");
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

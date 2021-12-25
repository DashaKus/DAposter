package Logic;

import java.io.*;
import java.util.Scanner;

public class User<file> {

    public int write_user_info(String log,String pass,String n) throws FileNotFoundException {
        int sum=0;
        File file = new File("src/Info/User_Info");
        String filePath=new String("src/Info/User_Info");
        Scanner scanner1 = new Scanner(file);
        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            String[] user = line.split("\n");
            for (int i = 0; i < user.length; i++) {
                System.out.println(user[i]);
                String[] user_login = user[i].split(",");
                if ( log.equals(user_login[0])) {
                    sum++;
                    return sum;
                }
            }
        }
        scanner1.close();
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(log);
            bufferWriter.write(",");
            bufferWriter.write(pass);
            bufferWriter.write(",");
            bufferWriter.write(n);
            bufferWriter.write("\n");
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        String path="src/Info/" + log+".txt";
        File newFile = new File(path);
        try
        {
            boolean created = newFile.createNewFile();
            if(created)
                System.out.println("File has been created");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return sum;
    }


    public int correctinfo(String login, String passsword) throws FileNotFoundException {
        File file = new File("src/Info/User_Info");
        Scanner scanner1 = new Scanner(file);
        int sum = 0;
        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            String[] user = line.split("\n");
            for (int i = 0; i < user.length; i++) {
                System.out.println(user[i]);
                String[] user_login = user[i].split(",");
                // System.out.println(user_login[0]);
                //   System.out.println(user_login[1]);
                if (passsword.equals(user_login[1]) & login.equals(user_login[0])) {
                    sum++;
                    return sum;
                }
            }
        }
        scanner1.close();
        return sum;
    }
}

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Do you want to encrypt or decrypt: ");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        String message="";
        int key = 0;
        if(choice.equals("encrypt")){
            System.out.println("What is your message ");
            message = in.nextLine();
            System.out.println("What is the key you want to use: ");
            key = in.nextInt();
            Cipher cip = new Cipher(key);
            writeToAFile(cip.encrypt(message));

        }
        else if(choice.equals("decrypt")){
//            System.out.println("What is your message ");
//            message = in.nextLine();
            System.out.println("What is the key you want to use: ");
            key = in.nextInt();
            String use = readAFile();
            Cipher cip = new Cipher((key));
            System.out.println(cip.decrypt(use));
        }
//        try{
//            InputStream input = new FileInputStream("textFiles\\cryptic.txt");
//            OutputStream output = new FileOutputStream("textFiles\\cryptic.txt");
//            Cipher cip = new Cipher(key);
//            //cip.encrypt(input,output);
//            System.out.println(cip.decrypt(input));
//
//            input.close();
//            output.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    public static void writeToAFile(String message) {
        try{
            Files.writeString(Paths.get("textFiles\\cryptic.txt"), message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String readAFile() {
        ArrayList<Character> myCarList = new ArrayList<>();
        String temp;
        String j = "";
        try {
            temp = Files.readString(Paths.get("textFiles\\cryptic.txt"));
            j = temp;
            for(int i = 0; i <= temp.length() -1; i++) {
                myCarList.add(temp.charAt(i));
            }
            return temp;
  //          return myCarList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
//        return myCarList;
    }

}

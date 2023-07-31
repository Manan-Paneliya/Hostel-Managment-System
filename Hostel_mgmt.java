
import java.io.FileWriter;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.time.LocalDate; //for date

class Hostel {
    String hostel_name = "Dharmajivan Chatralai";

    void inc_sid(){
        String filePath = "incrementer.txt";

        try {
            // Read the entire contents of the file into a string
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));

            // Print the contents of the file
            // System.out.println(fileContent);
            int id = Integer.parseInt(fileContent);
            try {
                FileWriter filewriter =  new FileWriter("incrementer.txt");
                int integer_val = id+1 ;
            String str = Integer.toString(integer_val) ;
            filewriter.write(str);
            filewriter.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// ****************************************************
    void add_student(){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter name : ");
            String name = sc.nextLine();
            String replaced_name = name.replace(" ","_");

            System.out.print("add diposit :");
            String diposit = sc.nextLine();

            System.out.print("address : ");
            String address = sc.nextLine();
            String replaced_add = address.replace(" ","_");

            System.out.print("mobile number : ");
            String mo_num = sc.nextLine();
            
            String fPath = "incrementer.txt";
            try {
            String id = new String(Files.readAllBytes(Paths.get(fPath)));
            

            String textToAppend = id+" "+replaced_name + " " +diposit+" "+replaced_add+" "+mo_num; 
            // no_of_student++;
            inc_sid();
            String filePath = "hari.txt";

            // String textToAppend = "8 jasmin_paneliya 3500 ajidam_rajkot 9875413518";
           
                // Create a FileWriter object with the file path and set append mode to true
                FileWriter fileWriter = new FileWriter(filePath, true);

                // Create a BufferedWriter object using the FileWriter
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // Write the text to the file
                bufferedWriter.write(textToAppend);

                // Add a new line character if needed
                bufferedWriter.newLine();

                // Close the BufferedWriter
                bufferedWriter.close();

                System.out.println("Text appended to the file successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred while appending text to the file: " + e.getMessage());
            }
        }
    }

// ****************************************************

    void show_detail_of(int s_id){
        String filePath = "hari.txt";
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str = contentBuilder.toString();
       
        // Split the string into lines
        String[] lines = str.trim().split("\n");
 
        // Determine the number of rows and columns
        int rows = lines.length;
        int columns = lines[0].trim().split("\\s+").length;

        // Create the 2D array
        String[][] array2D = new String[rows][columns];

        // Populate the 2D array
        for (int i = 0; i < rows; i++) {
            String[] values = lines[i].trim().split("\\s+");
            array2D[i] = values;
        }

        // Display the 2D array
        String std_id = Integer.toString(s_id);
        for (int i = 0; i < array2D.length; i++) {
            String a = array2D[i][0];
            if (a.equals(std_id)) {
                for (int j = 0; j < array2D[i].length; j++) {
                    System.out.print(array2D[i][j] + " ");
                }
            }
            
        }
    }
        
    

// ****************************************************

    void show_all_students(){
        System.out.println("show all students.....");
        String filePath = "hari.txt";
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str = contentBuilder.toString();
        System.out.println(str);
    }

// ****************************************************


    void Change_amount(int s_id, String o, int amount){
        System.out.println("add amount of...");
        String filePath = "hari.txt";
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str = contentBuilder.toString();
       
        // Split the string into lines
        String[] lines = str.trim().split("\n");
 
        // Determine the number of rows and columns
        int rows = lines.length;
        int columns = lines[0].trim().split("\\s+").length;

        // Create the 2D array
        String[][] array2D = new String[rows][columns];

        // Populate the 2D array
        for (int i = 0; i < rows; i++) {
            String[] values = lines[i].trim().split("\\s+");
            array2D[i] = values;
        }

        // Display the 2D array
        String std_id = Integer.toString(s_id);
        if (o == "+") {
        for (int i = 0; i < array2D.length; i++) {
            String a = array2D[i][0];
            
            if (a.equals(std_id)) {
                int diposit = Integer.parseInt(array2D[i][2]);
                diposit= diposit + amount ;
                String dp = Integer.toString(diposit);
                // System.out.println(dp);
                array2D[i][2] = dp ;
                for (int j = 0; j < array2D[i].length; j++) {
                    // System.out.print(array2D[i][j] + " ");
                }   
            }   
        }
        String all = "";
        for (int i = 0; i < array2D.length; i++) {
            String a = array2D[i][0];
            String line = "";
            for (int j = 0; j < array2D[i].length; j++) {
                
                line = line.concat(array2D[i][j]+" ");
            }
            all = all.concat(line+"\n")  ; 
        }

        try {
            FileWriter filewriter =  new FileWriter("hari.txt");
        filewriter.write(all);
        filewriter.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        }
        // code of else
        else{

            for (int i = 0; i < array2D.length; i++) {
                String a = array2D[i][0];
                
                if (a.equals(std_id)) {
                    int diposit = Integer.parseInt(array2D[i][2]);
                    diposit= diposit - amount ;
                    String dp = Integer.toString(diposit);
                    array2D[i][2] = dp ;
                    for (int j = 0; j < array2D[i].length; j++) {
                        // System.out.print(array2D[i][j] + " ");
                    }   
                }   
            }
            String all = "";
        for (int i = 0; i < array2D.length; i++) {
            String a = array2D[i][0];
            String line = "";
            for (int j = 0; j < array2D[i].length; j++) {
                
                line = line.concat(array2D[i][j]+" ");
            }
            all = all.concat(line+"\n")  ; 
        }

        try {
            FileWriter filewriter =  new FileWriter("hari.txt");
        filewriter.write(all);
        filewriter.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        }
        }
    

// ****************************************************
void delete_student_of(int s_id){
    System.out.println("student deleted...");
    System.out.println("add amount of...");
        String filePath = "hari.txt";
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str = contentBuilder.toString();
       
        // Split the string into lines
        String[] lines = str.trim().split("\n");
 
        // Determine the number of rows and columns
        int rows = lines.length;
        int columns = lines[0].trim().split("\\s+").length;

        // Create the 2D array
        String[][] array2D = new String[rows][columns];

        // Populate the 2D array
        for (int i = 0; i < rows; i++) {
            String[] values = lines[i].trim().split("\\s+");
            array2D[i] = values;
        }

        // Display the 2D array
        String std_id = Integer.toString(s_id);
       
        for (int i = 0; i < array2D.length; i++) {
            String a = array2D[i][0];
            
            if (a.equals(std_id)) {
                int diposit = Integer.parseInt(array2D[i][2]);
                for (int j = 0; j < array2D[i].length; j++) {
                    // System.out.print(array2D[i][j] + " ");
                    array2D[i][j] = "" ;
                }   
            }   
        
        String all = "";
        for (int x = 0; x < array2D.length; x++) {
            String ar = array2D[x][0];
            String line = "";
            for (int j = 0; j < array2D[i].length; j++) {
                
                line = line.concat(array2D[x][j]+" ");
            }
            all = all.concat(line+"\n")  ; 
        }

        try {
            FileWriter filewriter =  new FileWriter("hari.txt");
        filewriter.write(all);
        filewriter.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        }
        // code of else
       
}
// ****************************************************

void take_attendence(){
    LocalDate currentDate = LocalDate.now();
    System.out.println(currentDate);
    String current_date = currentDate+"_.txt";
    String filePath = "hari.txt";

        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str = contentBuilder.toString();
       
        // Split the string into lines
        String[] lines = str.trim().split("\n");
 
        // Determine the number of rows and columns
        int rows = lines.length;
        int columns = lines[0].trim().split("\\s+").length;

        // Create the 2D array
        String[][] array2D = new String[rows][columns];

        // Populate the 2D array
        for (int i = 0; i < rows; i++) {
            String[] values = lines[i].trim().split("\\s+");
            array2D[i] = values;
        }

        // Display the 2D array
       
        System.out.println("Taking Attendence....\nnote:\n     write 'p' if present otherwise 'a' ");
        String all = "";
        int p = 0 ;
        int a = 0 ;
        for (int x = 0; x < array2D.length; x++) {
            for (int j = 0; j < array2D[x].length; j++) {
                Scanner sc = new Scanner(System.in);
                System.out.print(array2D[x][1]+" : ");
                String input = sc.nextLine();
                System.out.println(input);
                if (input.equals("p")) {
                    p = p + 1;
                    input = "Present";
                }
                else{
                    a = a +1 ;
                    input = "Absent";
                }
               
                
                
                String line = array2D[x][1] +" : "+input+"\n" ;
                all = all + line ;
                break ;
            }
        }
        String total = "Total Absent : "+a+"\nTotal Present : "+p;
        all = all + total ;
        File myfile = new File(filePath);
        try {
            myfile.createNewFile();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error is occured");
        }
        try {
            FileWriter filewriter =  new FileWriter(current_date);
        filewriter.write(all);
        filewriter.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
}

void refresh(){
    System.out.println("student deleted...");
    System.out.println("add amount of...");
        String filePath = "hari.txt";
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str = contentBuilder.toString();
       
        // Split the string into lines
        String[] lines = str.trim().split("\n");
 
        // Determine the number of rows and columns
        int rows = lines.length;
        int columns = lines[0].trim().split("\\s+").length;

        // Create the 2D array
        String[][] array2D = new String[rows][columns];

        // Populate the 2D array
        for (int i = 0; i < rows; i++) {
            String[] values = lines[i].trim().split("\\s+");
            array2D[i] = values;
        }

        // Display the 2D array
       
        
        String all = "";
        for (int x = 0; x < array2D.length; x++) {
            String ar = array2D[x][0];
            String line = "";
            for (int j = 0; j < array2D[x].length; j++) {
                if (array2D[x][j] != "") {
                    
                line = line.concat(array2D[x][j]+" ");
                }
            }
            if (line != "") {
                all = all.concat(line+"\n")  ;    
            }
        }

        try {
            FileWriter filewriter =  new FileWriter("hari.txt");
        filewriter.write(all);
        filewriter.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        }
}

// ****************************************************

    


class Student extends Hostel {  
    void a(){
        System.out.println();
    }
}


public class Hostel_mgmt implements db {
    public static void main(String[] args) {
        // Student s1 ;
        Hostel s1 = new Hostel();
        String inp = "0";
        while (!(inp.equals("exit"))) {
            if (inp.equals("0")) {
                System.out.println("\nadd Student (1)\nShow Details of perticular Student (2)\nShow Details of all Students (3)\nDiposit (4)\nDelete Student (5)\nTake Attendance (8)\n");
            System.out.print("\nEnter : ");
            Scanner sc = new Scanner(System.in);
            inp = sc.nextLine() ;
            if (inp.equals("1")) {
                s1.add_student();
                // inp = "0";
                
                
                
            } 
            else if(inp.equals("2")){
                System.out.println("Enter Student ID : ");
                int id = sc.nextInt();
                s1.show_detail_of(id);
                inp = "0";
            }
            else if(inp.equals("3")){
                s1.show_all_students();
                inp = "0" ;
            }
            else if(inp.equals("4")){
                while (!((inp.equals("exit"))||(inp.equals("back")))) {
                    System.out.println("add amount (6)\ndeduct amount (7)");
                System.out.print("\nEnter : ");
                inp = sc.nextLine();
                if (inp.equals("6")) {
                    System.out.println("Enter Student ID : ");
                    int id = sc.nextInt();
                    System.out.println("Enter Amount : ");
                    int am = sc.nextInt();
                    s1.Change_amount(id, "+", am);
                } else {
                    System.out.println("Enter Student ID : ");
                    int id = sc.nextInt();
                    System.out.println("Enter Amount : ");
                    int am = sc.nextInt();
                    s1.Change_amount(id, "-", am);
                }
                }
                inp = "0";
            }
            else if(inp.equals("5")){
                System.out.println("Enter Student ID : ");
                int id = sc.nextInt();
                s1.delete_student_of(id);
                inp = "0";
            }
            else if(inp.equals("8")){
                s1.take_attendence();
            }
            else {
                
            // System.out.println("Invalid Input");
            // System.exit(0);
            }
            }
        }

    }
}


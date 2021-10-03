package mod1;

/**
    * PROGRAM DETAILS
    * By Dane Selch
    * created on: 10-1-21
    * Program: Covid Variants organizer
    * Class CSE310 
    * Purpose: Allow the user to access informatin from a 
    *   covid variant database to answer these questoins
    *       1. what are all the sequenced variants to date. 
    *       2. list the variants in a specific  location
    */

import java.util.Scanner;
import java.io.File;
import java.text.ParseException;
import java.io.IOException;


public class App {
   
    /**
     * Method: main()
     * the driver function. this will loop till
     * it recieves an input of '0' from the user 
     * signaling to close the program.
     */
    public static void main(String[] args) throws Exception {
        int holdThis = 0;
        boolean looping = true;
        String opening = "\nThis program accesses a database that contains the variants\n" +
        "of the covid virus that has been sequenced in different \n countries";

        String opt1 = "\n\t 1. See all the sequenced variants from every individual sample";
        String opt2 = "\n\t 2. See the variants at a specific location";
        System.out.println(opening + opt1 + opt2);
        
        while (looping == true){
            holdThis = getInput();
            
            System.out.print(holdThis);
            switch (holdThis){
                case 0:
                    looping = false;
                    break;
                case 1:
                    getAllVariants();
                    break;
                case 2:
                    variantsAtLoc();
                    break;
                default: System.out.println("\n ERROR: input is invalid\n");
            }

        }

        System.out.println("loop has been broken");
    }

    /**
    * method: getInput
    * purpose: get the input form the user
    **/
    public static int getInput(){
        System.out.print("\nwhat would you like to ask the mighty covid database?\n(please use the corresponding number above to select your choice)"); 
        Scanner inPut = new Scanner(System.in);
        int choice = inPut.nextInt();
        inPut.close();
        return choice;
    }

    /**
    * method: variantsAtLoc()
    * purpose: Read the file and return only the entries at a specific place
    **/
    public static void variantsAtLoc() throws  ParseException{
        String location = promptLoc();
        try{    
            File file1 = new File("src\\mod1\\covid-variants.csv");
            Scanner sc = new Scanner(file1);
            int i = 0; // line number
            
            while (sc.hasNextLine()){
                if (i == 0){
                System.out.print(sc.nextLine());
                } else {
                String holder = sc.nextLine();
                breakItDownMORE(holder, location);
                }
                i++;
            }
            sc.close();        
        }
        catch(IOException ex){
            System.out.println("Error loading file");
        }
    }

    /**
    * method: getAllVariants()
    * purpose: promps for a location, reads data from file, then sends it to be broken down.
     * @throws ParseException
    **/
    public static void getAllVariants() throws ParseException{
        try{
            File file1 = new File("src\\mod1\\covid-variants.csv");
            Scanner sc = new Scanner(file1);
            int i = 0; // line number
            
            while (sc.hasNextLine()){
                if (i == 0){
                System.out.print(sc.nextLine());
                } else {
                String holder = sc.nextLine();
                breakItDown(holder);
                }
                i++;
            }
            sc.close();        
        }
        catch(IOException ex){
            System.out.println("Error loading file");
        }
        
    
    }

    /**
    * method: promptLoc()
    * purpose: get the location form the user that we will be using to filter out the data.
    **/
    public static String promptLoc(){
        
        Scanner holdme = new Scanner(System.in);
        System.out.println("Where shall we look?(please capitalize only the first letter)\n");
        String place = holdme.nextLine();
        holdme.close();
        return place;

    }

    static void breakItDown(String holder) throws ParseException {
        Sample tocan = new Sample();
        String splitter[] = holder.split(",",6);
        for (int i = 0; i< 6; i++)
        {
            if (i==0){
                tocan.setPlace(splitter[i]);
            }
            else if (i==1) {
                tocan.setFecha(splitter[i]);
            }
            else if (i==2){
                tocan.setvName(splitter[i]);
            }
            else if (i==3){
                int holdme = Integer.parseInt(splitter[i]); // turn string to int
                tocan.setNumb(holdme);
            }
            else if (i==4){

                Float holdme = Float.valueOf(splitter[i]);  
                tocan.setPerc(holdme);
                    
            }
            else if (i==5){

                int holdme = Integer.parseInt(splitter[i]);
                tocan.setsSize(holdme);
            }
        }
        if (tocan.getNumb() != 0){
            tocan.display();}
        }
       
    
/**
    * method: breakItDownMORE()
    * purpose: takes a string (single line of the file) and
    *   will  break it down into part than only displays those that are withn 
    *   the desired location.
    **/
    private static void breakItDownMORE(String holder, String Loc) throws ParseException {
        Sample tocan = new Sample();
        String splitter[] = holder.split(",",6);
        for (int i = 0; i< 6; i++)
        {
            if (i==0){
                tocan.setPlace(splitter[i]);
            }
            else if (i==1) {
                tocan.setFecha(splitter[i]);
            }
            else if (i==2){
                tocan.setvName(splitter[i]);
            }
            else if (i==3){
                int holdme = Integer.parseInt(splitter[i]); // turn string to int
                tocan.setNumb(holdme);
            }
            else if (i==4){

                Float holdme = Float.valueOf(splitter[i]);  
                tocan.setPerc(holdme);
                    
            }
            else if (i==5){

                int holdme = Integer.parseInt(splitter[i]);
                tocan.setsSize(holdme);
            }
        }
        if (tocan.getNumb() != 0 && tocan.getPlace() == Loc){
            tocan.display();
        }
    }
} 

        

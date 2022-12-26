package com.views;
import java.util.ArrayList;
import java.util.Scanner;

import com.support.DirectorySupport;
import com.support.ViewSupport;

import java.util.InputMismatchException;

public class WelcomeView implements Views{
	
	private String welcomeText = "Virtual Key For Your Repositories";
    private String developerText = "DEVELOPER : HRITIK LONDHE";

    private ArrayList<String> options = new ArrayList<String>();


    public WelcomeView() {
        options.add("1. Display all Files");
        options.add("2. Show Different File Operations");
        options.add("3. Quit");

    }
    
    public void introWS() {
        System.out.println("--------------------------------------------------------\n\n");
    	System.out.println("\t\t"+welcomeText+"\n\n");
        System.out.println(developerText);
        System.out.println("--------------------------------------------------------");
        System.out.println("\n");
        Show();
    }
	
	@Override
    public void Show() {
    	System.out.println("\nMain Menu\n"+"\nSelect Option"+"\n---------------------------------");
        for (String s : options)  {
            System.out.println(s);
        }

    }
	
	public void GetUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }
	
	@Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1: // Show Files in Directory
                this.ShowFiles();
                
                this.Show();
                
                break;
                
            case 2: // Show File Options menu
            	ViewSupport.setCurrentView(ViewSupport.FileOperationView);
            	ViewSupport.getCurrentView().Show();
            	ViewSupport.getCurrentView().GetUserInput();
                
                this.Show();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
        
    }
	
	public void ShowFiles() {

        //TODO: Get the files from the Directory
    	
    	//Finished TODO Task

        System.out.println("\nList of Files: \n"+"--------------------------------");
    	DirectorySupport.PrintFiles();

    }
	
	private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }
	
	

}
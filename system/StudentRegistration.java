/*This program is used to register students, The student input to program his/her first_name and last_name
 * Then he/she select her college and departement ,In this program there a demo of 3 colloge this are college of health,
 * college of computing and inforamtics and college of engineering.
 * In the college of health there is departement of Medicine and Pharamacy.
 * In the college of computing and infomatics there is departement of software engineering,computer science and information system.
 * In the college of engineering there is departement of civil,electrical and mechanical engineering. 
 * After selecting college and departement the user input his/her acadamical level(year) and semister it belong in
 * finally the program displays the kind of slip where there is his first name,last name college,departement,acadamic level and semister
 * including the course in that acadamic level and semister
 * 
 * This program have one class called StudentRegistration 5 method including the main, 8 file for each departement that contains all course that will be
 * taken in departement and one file which serve as database to store the registered student information.
 * 
 * The program read 3 course from each file according to the student acadamic level and semister(In this program we assume that in each semister
 * there is only three course to be taken by the student)
 * 
 * The password to access the database file is admin
 * */
package system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

// Main class of the program
public class StudentRegistration {
	 static String course = null; // Store the course the student will take
	 static Boolean correct = false; // This variable used to check if the input the user enter is correct or not(if it is correct break loop)
	 static int check = 0; // We Use this to check the input of the user
	 static String PASSWORD = "admin"; // The password that used to access the database file
	 
	public static void main(String[] args) {
		//int max_student = 80; // Maximum number of student that can be registered
		String first_name = null; // First name of the student
		String last_name = null;  // Last name of the student
		String [] coll = {"COLLEGE OF HEALTH","COLLEGE OF COMPUTING AND INFORMATICS","COLLEGE OF ENGINEERING"};  // Sample list of colleges
		String [] dept_health = {"Medicine","Pharamacy"} ; // The college of Health with it department list
		String [] dept_cci  = {"Software engineering","Computer science","Information system"}; // college of computing and informatics with it departement list
		String [] dept_engineering = {"Civil engineering","Electrical engineering","Mechanical engineering"}; // college of Engineering with it departement list
		int Year = 0;  // The batch where the student belong
		int semister = 0; // stores the semister the student will in
		String departement = null; // Store the departement the student choose
		String college = null; // Store the college the student choose	
		int i = 0,j = 0;   // Variable used to control iteration of loop and also used to access elements of array
		
		
		while (correct == false) {  // This loop continue until valid input is entered
			System.out.println("Enter your First name");
			Scanner input1 = new Scanner(System.in);
			first_name = input1.next();
			if (first_name.matches("[a-zA-Z]+")) {
				correct = true;	// Breaks the loop
			} else {
				System.out.println(" Invalid input, First name can only be letters");
				continue;
			}
		}
		
        correct = false;
		while (correct == false) {  // This loop continue until valid input is entered
			System.out.println("Enter your Last name");
			Scanner input2 = new Scanner(System.in);
			last_name = input2.next();
			if (last_name.matches("[a-zA-Z]+")) {
				correct = true;	 // Breaks the loop
			} else {
				System.out.println(" Invalid input, Last name can only be letters");
				continue;
			}
		}
		
		correct = false;
		while (correct == false) {  // This loop continue until valid input is entered

			 try {
				 System.out.println("Choose your college(Enter 0 for College of health,1 for College of computing and informatics,2 for engineering)");
				 Scanner input3 = new Scanner(System.in);
				 int v = input3.nextInt();
				 if (v <= 2 && v >= 0) {
					 college = coll[v];
					 correct = true;  // Breaks the loop
				 } else {
					 System.out.println("Enter valid input , it must be 0 , 1 or 2");
				 }
		     }catch (InputMismatchException e) {
					System.out.println("Invalid information, You must enter number");
				}
		}
		
		if (college == coll[0]) {
			correct = false;
			while (correct == false) {  // This loop continue until valid input is entered
				 try {
					 System.out.println("Choose your Departement(Enter 0 for Medicine departement and 1 for Pharmacy departement)");
					 Scanner input4 = new Scanner(System.in);
					 int v = input4.nextInt();
					 
					 if (v <= 1 && v >= 0) {
						 departement = dept_health[v];
						 correct = true; // Breaks the loop
					 } else {
						 System.out.println("Enter valid input , it must be 0 or 1");
					 }
			     }catch (InputMismatchException e) {
						System.out.println("Invalid information, You must enter number");
					}
			}
		}else if (college == coll[1]) {
			correct = false;
			while (correct == false) {  // This loop continue until valid input is entered
				 try {
					 System.out.println("Choose your Departement(Enter 0 for software engineering departement,1 for Computer science and 2 for Information system");
					 Scanner input4 = new Scanner(System.in);
					 int v = input4.nextInt();
					 
					 if (v <= 2 && v >= 0) {
						 departement = dept_cci[v];
						 correct = true;  // Breaks the loop
					 } else {
						 System.out.println("Enter valid input , it must be 0 , 1 or 2");
					 }
			     }catch (InputMismatchException e) {
						System.out.println("Invalid information, You must enter number");
					}
			}
		} else {
			correct = false;
			while (correct == false) { // This loop continue until valid input is entered
				 try {
					 System.out.println("Choose your Departement(Enter 0 for civil engineering, 1 for Electrical engineering and 2 for Mechanical engineering)");
					 Scanner input4 = new Scanner(System.in);
					 int v = input4.nextInt();
					 
					 if (v <= 2 && v >= 0) {
						 departement = dept_engineering[v];
						 correct = true; // Breaks the loop
					 } else {
						 System.out.println("Enter valid input , it must be 0, 1 or 2");
					 }
			     }catch (InputMismatchException e) {
						System.out.println("Invalid information, You must enter number");
					}
			}
		}
		
		correct = false;
		while (correct == false) { // This loop continue until valid input is entered
			System.out.println("Enter your Batch");
		    try{
		    	Scanner input7 = new Scanner(System.in);
				Year = input7.nextInt();
				if (Year > 7 || Year < 0) {
					System.out.println("Batch must be less or equal to 7 and greater than 0");
				}else {
					correct = true; // Breaks the loop
				}
		    }catch (InputMismatchException e) {
				System.out.println("Invalid information, Batch must be numerical value");
			}
		}
		
		correct = false;
		while (correct == false) { // This loop continue until valid input is entered
			 System.out.println("Semister you are registering in(Enter 1 if it is first semister or 2 if it is second semister)");
		     try {
		    	 Scanner input8 = new Scanner(System.in);
		 		 semister = input8.nextInt();
		 		 if (semister == 2 || semister == 1) {
		 			correct = true; // Breaks the loop
		 		 } else {
		 			 System.out.println(" Invalid input Semister must 1 or 2");
		 		 }			    
		     }catch (InputMismatchException e) {
					System.out.println("Invalid information, Enter number");
				}
		}
		
		try {
			Scanner scanner = new Scanner(new File("C:\\Users\\firaf\\git\\repository\\java_project\\src\\system\\" + departement));
			
			scanner.useDelimiter("&");
			j = 1;
			while(scanner.hasNext()) {
				course = scanner.next();
				i++;
				if (i == 3) {
					i = 1;
					j++;
				}
				if (j == Year && i == semister) {
					break;
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("You hava been registered successfully! ");
	    
		//Displaying the information of the registered student
		display(first_name,last_name,college,departement);  // calling the display function
		display(Year,semister); // calling display function which polyimoriphism
		
		// Storing the information into a file
		storedata(first_name,last_name,college,departement,Year,semister);
      
        // Displaying the information stored in the database file
		displaydatabase();

    }
        	
	public static void clearscreen() { // Used to show a cleered screen effect but the screen is not cleered
		for (int i = 0;i<50;i++) {
			System.out.println();
		}	
	}
	
	 // Method used to display the information of the student
	public static void display(String firstname,String lastname,String college,String departement) {
		System.out.println("FIRST_NAME: " + firstname);
		System.out.println("___________________________________________________________________________________________________________");
		System.out.println("LAST_NAME: " + lastname);
		System.out.println("___________________________________________________________________________________________________________");
		System.out.println("COLLEGE: " + college);
		System.out.println("___________________________________________________________________________________________________________");
		System.out.println("DEPARTEMENT: " + departement);
	}
	
	// Method used to display the numirical information of the student
	public static void display(int batch,int semister) {   
		
		System.out.println("___________________________________________________________________________________________________________");
		System.out.println("BATCH: " + batch);
		System.out.println("___________________________________________________________________________________________________________");
		System.out.println("SEMISTER: " + semister);
		System.out.println("___________________________________________________________________________________________________________");
		System.out.println("The above student has been registered successfully for this courses");
		System.out.println("___________________________________________________________________________________________________________");
		System.out.println(course);
	    System.out.println("___________________________________________________________________________________________________________");
	}
    
	// Method used to store the information into database file
	public static void storedata(String firstname,String lastname,String college,String departement,int batch,int semister) {
		
		try (FileWriter writer = new FileWriter("C:\\Users\\firaf\\git\\repository\\java_project\\src\\system\\Database",true)) {
			writer.write("FIRST_NAME: " + firstname + "\n");
			writer.write("___________________________________________________________________________________________________________\n");
			writer.write("LAST_NAME: " + lastname + "\n");
			writer.write("___________________________________________________________________________________________________________\n");
			writer.write("COLLEGE: " + college + "\n");
			writer.write("___________________________________________________________________________________________________________\n");
			writer.write("DEPARTEMENT: " + departement + "\n");
			writer.write("___________________________________________________________________________________________________________\n");
			writer.write("BATCH: " + batch + "\n");
			writer.write("___________________________________________________________________________________________________________\n");
			writer.write("SEMISTER: " + semister + "\n");
			writer.write("___________________________________________________________________________________________________________\n");
			writer.write("The above student has been registered successfully for this courses\n");
			writer.write("___________________________________________________________________________________________________________\n");
			writer.write(course + "\n");
			writer.write("___________________________________________________________________________________________________________\n");
			writer.write("***********************************************************************************************************\n");
			writer.write("***********************************************************************************************************\n");
			writer.write("***********************************************************************************************************\n");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	// A method used to display the information stored in database
	public static void displaydatabase() {  
		
		correct = false;
	    while (correct == false) { // This loop continue until valid input is entered

	        try {
	        	System.out.println("Do you want to see the information of student that has been registered(Enter any number to see and 0 to exit the program)");
	    		Scanner input10  = new Scanner(System.in);
	    		check = input10.nextInt();
	    	    correct = true;  // Breaks the loop
				} catch (InputMismatchException e) {
					System.out.println("Invalid input please enter number");
					}
	    	}
	   
			if (check != 0) {
		    	correct = false;
		    	while (correct == false) { // This loop continue until valid input is entered
		    		System.out.println("To access the database file please enter the password(admin password(type admin)");
			    	Scanner input10  = new Scanner(System.in);
			    	String pass = input10.next();
			    	System.out.println(pass);
		    		if (pass.equals(PASSWORD)) {
			    		clearscreen();
			    		Scanner file;
						try {
							file = new Scanner(new File("C:\\Users\\firaf\\git\\repository\\java_project\\src\\system\\Database"));
							file.useDelimiter("\n");
							while(file.hasNext()) {
				    			String info = file.next();
				    			System.out.println(info);
				    		}
							correct = true;  // Breaks the loop
						} catch (FileNotFoundException e) {    
							e.printStackTrace();
					      }
			        } else {
			            	System.out.println("Incorrect password Please try again");
			          }	
		        }	
		    }
		
	}
}
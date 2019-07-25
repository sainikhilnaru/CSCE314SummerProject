import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Write code to load the workouts from the provided workouts.csv file. The function should return a Workouts object.

public class FileAccess extends Workouts{
  
  public static Workouts loadWorkouts() {
    // What is a try/catch block and why do we need one?

    // What is an exception?
	 
	  Workouts workouts = new Workouts(); //create a new Object workouts
	    
	  	try {
			File file = new File(Config.WORKOUTFILE);//A File object is created by passing in a String that
			// represents the name of a file, or a String or another File object
	      Scanner scanner = new Scanner(file);// initialized a Scanner object so that it reads from a file

	      while (scanner.hasNextLine()) {
	      	//the hasNextLine() method of java.util.Scanner class returns true if there is another line in the input of this scanner
	        String lineUserInput = scanner.nextLine();
	        String[] strings = lineUserInput.split(",");//return a string array separated by commas
	        //Java String split method is used for splitting a String into its substrings based on the given delimiter or regular expression.
	        String name = strings[0];
	        Equipment equipment = Equipment.valueOf(strings[1]);//The valueOf method returns the relevant Number Object holding the value of the argument passed.
	        Muscle primaryMuscle = Muscle.valueOf(strings[2]);
	        Muscle secondaryMuscle = Muscle.valueOf(strings[3]);
	        String desc = strings[4];
	        String reminders = strings[5];
	        workouts.addWorkout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
	      }

	      scanner.close();

	  	}
	    catch (FileNotFoundException e)
	    {
	      System.out.println("we ARE Unable to find your workouts file. Change your directory");
	    }
	    return workouts;
	  }
  

}

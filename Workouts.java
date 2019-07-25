import java.util.ArrayList; // We choose ArrayList over Vector because...? 
/**
* Use the provided enumerations and code framework to create our workouts class.
* This class should contain all the functionality we need to interact with our workout list.
* Minimize duplication of code by writing helper functions as needed.
* 
* Do not change any of the provided code, although you can, and should, add to it as needed. 
* (E.G. Do not make private attributes public, or change the parameters of a function.)
*/

public class Workouts {

  // Use the Refactor functionality in Eclipse to rename "muscle" to "Muscle" to match our naming convention.
  public enum Muscle {ABS, BACK, BICEPS, CHEST, FOREARM, GLUTES, LOWERLEG, SHOULDER, TRICEPS, UPPERLEG, NONE} // Why didn't I have to declare this static?
  public enum Equipment {BARBELL, BODYWEIGHT, DUMBBELL, CABLE, HAMMERSTRENGTH}
  private final ArrayList<Workout> workoutList = new ArrayList<Workout>();

	// This is a nested class, also known as an inner class. Why do we use a nested class?
	// You will need to create a number of methods for the inner class. You are not limited to 
	// only the methods listed inside this class.
	private class Workout {
		private String name;
		private Equipment equipment;
		private Muscle primaryMuscle;
		private Muscle secondaryMuscle;
		private String desc;
		private String reminders;

		Workout(String name, Equipment equipment, Muscle primaryMuscle, Muscle secondaryMuscle, String desc, String reminders) {
			// How do we get the name of an enumeration value?
			this.name = name;
			this.equipment = equipment;
			this.primaryMuscle = primaryMuscle;
			this.secondaryMuscle = secondaryMuscle;
			this.desc = desc;
			this.reminders = reminders;
			//done
		}

		public boolean isPrimaryMuscle(Muscle muscle) {
			// TODO Auto-generated method stub
			return primaryMuscle == muscle;
		}

		public boolean isSecondaryMuscle(Muscle muscle) {
			// TODO Auto-generated method stub
			return secondaryMuscle == muscle;

		}

		public boolean IsEquipment(Equipment equip) {
			// TODO Auto-generated method stub
			return equipment == equip;
		}

		public boolean IsEquipment(ArrayList<Equipment> e) {
			// TODO Auto-generated method stub
			for (Equipment equip : e) {// This is a ForEach, and uses an iterator in the background to loop through the collection.
				if (IsEquipment(equip)) return true;
			}
			return false;
		}

		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}

		public String getEquipment() {
			// TODO Auto-generated method stub
			return equipment.toString();
		}

		public String getPrimaryMuscle() {
			// TODO Auto-generated method stub
			return primaryMuscle.toString();
		}

		public String getSecondaryMuscle() {
			// TODO Auto-generated method stub
			return secondaryMuscle.toString();
		}

		public String getDesc() {
			// TODO Auto-generated method stub
			return desc;
		}

		public String getReminders() {
			// TODO Auto-generated method stub
			return reminders;
		}


	}
	
  // This function adds a new workout to the Workouts object.
  public final void addWorkout(String name, Equipment equipment, Muscle primaryMuscle, Muscle secondaryMuscle, String desc, String reminders)
  {
	  Workout w1 = new Workout( name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
	  workoutList.add(w1);
  }
  
  // This function adds a workout to the Workouts object.
  public final void addWorkout(Workout workout)
  {

  	workoutList.add(workout);
  }
  
  // This list returns a new Workouts object that contains only the workouts that contain the
  // Equipment value that is provided as an argument. The programmer has an option to get
  // Workouts that only have the Muscle in the PrimaryMuscle attribute, or to also look
  // in the secondaryMuscle category.
	public final Workouts getWorkoutsByMuscle(Muscle m, boolean includeSecondary)
	{
		Workouts work1 = new Workouts();
		  for(Workout w1 : workoutList) {
		    if(w1.isPrimaryMuscle(m)) {
		      work1.addWorkout(w1);
		    }
		    else if (w1.isSecondaryMuscle(m) && includeSecondary) {//as given in Java fit//if false then it will skip condition
		      work1.addWorkout(w1);
		    }
		  }

		  return work1;// What is short-circuit evaluation?
	}
	
	// This list returns a new Workouts object that contains only the workouts that contain the
	// Equipment value that is provided as an argument.
  public final Workouts getWorkoutsByEquipment(Equipment e)
  {
	  Workouts work2 = new Workouts();
	    for(Workout w2 : workoutList) {
	      if(w2.IsEquipment(e)) {
	        work2.addWorkout(w2);
	      }
	    }
	    return work2;
  }
	
  // This returns a new Workouts object that contains only the workouts that contain an Equipment
  // value that is in the provided ArrayList of Equipment.
  public final Workouts getWorkoutsByEquipment(ArrayList<Equipment> e)
  {
	  Workouts work3 = new Workouts();
	    for(Workout w3 : workoutList) {
	      if(w3.IsEquipment(e)) {
	        work3.addWorkout(w3);
	      }
	    }
	    return work3;
  }
	
  // This method returns an ArrayList of Strings. Each String is a name of a workout in our Workouts list.
  public final ArrayList<String> getNames()
  {
	  ArrayList<String> work4 = new ArrayList<String>();
	    for(Workout w4 : workoutList) {
	      work4.add(w4.getName());
	    }
	    return work4;
  }
 
  // This method returns all the information of the Workouts as an ArrayList of String arrays, 
  // one entry in the ArrayList per Workout. The String array should contain the workout's Name, 
  // Equipment, Primary and Secondary Muscles, Description, and Reminders. All of these should be strings.
  public final ArrayList<String[]> getFullInformation()
  {
	  ArrayList<String[]> work6 = new ArrayList<String[]>();
	    for(Workout w6 : workoutList) {
	      String[] strings1 = new String[6];
	      strings1[0] = w6.getName();
	      strings1[1] = w6.getEquipment();
	      strings1[2] = w6.getPrimaryMuscle();
	      strings1[3] = w6.getSecondaryMuscle();
	      strings1[4] = w6.getDesc();
	      strings1[5] = w6.getReminders();
	      work6.add(strings1);
	    }
	    return work6;  
  }
}

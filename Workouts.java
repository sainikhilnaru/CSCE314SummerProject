import java.util.ArrayList; // We choose ArrayList over Vector because...?


public class Workouts {

  private final ArrayList<Workout> workoutList = new ArrayList<Workout>();
  public final int size() {
    return workoutList.size();
  }
  public final Workout getWorkout(int index) {
    return workoutList.get(index);
  }
  public final String getWorkoutEquipment(int index) {
    return this.workoutList.get(index).getEquipment();
  }
  public final int findWorkoutByName(String s) {
    for (int i=0; i<workoutList.size(); i++) {
      if (workoutList.get(i).getName() == s)
        return i;
    }
    return -1;
  }
  public final void addWorkout(String name, Config.Equipment equipment, Config.Muscle primaryMuscle, Config.Muscle secondaryMuscle, String desc, String reminders)
  {
    Workout newWorkout = new Workout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
    workoutList.add(newWorkout);
  }
  public final void addWorkout(Workout workout)
  {
    workoutList.add(workout);
  }
  public final Workouts getWorkoutsByMuscle(Config.Muscle m, boolean includeSecondary) {
    Workouts retval = new Workouts();
    for(Workout w : workoutList) {
      if(w.hasPrimaryMuscle(m)) {
        retval.addWorkout(w);
      }
      else if (includeSecondary && w.hasSecondaryMuscle(m)) { // Why did I put the includeSecondary first?
        retval.addWorkout(w);
      }
    }
    return retval;
  }
  public final Workouts getWorkoutsByMuscle(ArrayList<Config.Muscle> m, boolean includeSecondary) {
    Workouts retval = new Workouts();
    for (Workout w : workoutList) {
      if (w.hasPrimaryMuscle(m) || (w.hasSecondaryMuscle(m) && includeSecondary))
        retval.addWorkout(w);
    }
    return retval;
  }
  public final Workouts getWorkoutsByEquipment(Config.Equipment e)
  {
    Workouts retval = new Workouts();
    for(Workout w : workoutList) {
      if(w.hasEquipment(e)) {
        retval.addWorkout(w);
      }
    }
    return retval;
  }
  public final Workouts getWorkoutsByEquipment(ArrayList<Config.Equipment> e)
  {
    Workouts retval = new Workouts();
    for(Workout w : workoutList) {
      if(w.hasEquipment(e)) {
        retval.addWorkout(w);
      }
    }
    return retval;
  }
  public final ArrayList<String> getEquipment() {//new
    boolean boolValue = false;
    ArrayList<String> retval = new ArrayList<String>();
    for(Workout work : workoutList) {
      for (String string : retval) {
        if (string.equalsIgnoreCase(work.getEquipment()))
          boolValue = true;
      }
      if (! boolValue)
        retval.add(work.getEquipment());
    }
    return retval;
  }

  public final ArrayList<String> getNames()
  {
    ArrayList<String> retval = new ArrayList<String>();
    for(Workout w : workoutList) {
      retval.add(w.getName());
    }
    return retval;
  }
 
  public final ArrayList<String[]> getFullInformation()
  {
    ArrayList<String[]> retval = new ArrayList<String[]>();
    for(Workout w : workoutList) {
      String[] info = new String[6];
      info[0] = w.getName();
      info[1] = w.getEquipment();
      info[2] = w.getPrimaryMuscle();
      info[3] = w.getSecondaryMuscle();
      info[4] = w.getDesc();
      info[5] = w.getReminders();
      retval.add(info);
    }
    return retval; 
  }
}
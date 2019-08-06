import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumMap;

import javax.swing.*;
import java.awt.event.*;

// Bonus points: Create an icon (or find a public domain icon. Keep in mind federal Copyright law and TAMU's plagiarism policy and add it to the home screen window.
public class MainWindow implements ActionListener {

  private final JFrame OuterFrame = new JFrame(Config.APPLICATIONNAME);
  private final JDialog selectWorkout = new JDialog(OuterFrame, "Select Workout");
  private JComboBox<String> cboType, cboGoal;
  private JSpinner spnDuration;
  private final Workouts workouts;
  private final EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups;
  private Canvas canvas = new Canvas();// Canvas is a blank rectangular area where the user can draw or
  // trap input from the user. Canvas class inherits the Component class.

  private ArrayList<JButton> jButtonArrayList = new ArrayList<JButton>();


  MainWindow(Workouts workouts, EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups) {
    this.workouts = workouts;
    this.muscleGroups = muscleGroups;
    //OuterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    OuterFrame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
      }
    });
    canvas.setSize(600 , 400);
    this.launchHomeScreen();
  }

  private void launchHomeScreen() {//all new functions defined but  launch homescreen
    this.createButtons();
    this.buttonActionListener();
    OuterFrame.add(canvas);
    //Display the window.

    ImageIcon img = new ImageIcon("data/gymAppLogo1.PNG");
    OuterFrame.setIconImage(img.getImage());
    OuterFrame.pack();//The Window is validated after it* size is being calculated.
    //this sets the screen to it requirements
    OuterFrame.setVisible(true);
//    ImageIcon p = new ImageIcon();
//    try {
//      BufferedImage img = ImageIO.read(new File("data/UpperBody.png"));
//      JLabel lbl = new JLabel();
//      p.setImage(img);
//      lbl.setIcon(p);
//      OuterFrame.add(lbl);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    Image label = new JLabel("");
//    Image label = new ImageIcon(this.getClass().getResource("fs.png")).getImage();

  }

  private void addButton(int i , String S) {
    jButtonArrayList.add(new JButton(S));//created a new instance of JButton class and It creates a button with the specified text.
    OuterFrame.add(jButtonArrayList.get(i));
    jButtonArrayList.get(i).setBounds(5 ,20 + (i*125),590,125);
    // This sets the dimension of all three options
  }

  private void createButtons() {
    int counter = 0;
    for (Config.MuscleGroup group : muscleGroups.keySet()) {
      //return a set view of the keys contained in this enum map
      addButton(counter , group.toString());//there are three muscle groups
      counter++;
    }
  }

  private void buttonActionListener() {
    //this sets up a response when an option is clicked
    for (JButton jButton : jButtonArrayList){
      jButton.addActionListener(this);
    }
  }


  public void actionPerformed(ActionEvent e) {//implemented methods from actionListener
    //this a response
    JButton sourcees = (JButton)e.getSource();//object on which source is called
    callHandler(sourcees.getText());//return the buttons text/object value
  }

  private void callHandler(String s) {//new
    showWorkouts(muscleGroups.get(Config.MuscleGroup.valueOf(s)));
  }

  // This is the method your actionlistener should call. It should create and display a WorkoutsPanel.
  private void showWorkouts(ArrayList<Config.Muscle> muscles) {
    OuterFrame.getContentPane().removeAll();//remove previos words/jlabels that were added
    OuterFrame.add(new WorkoutsPanel(muscles , workouts));
    OuterFrame.validate();//validated
  }
}
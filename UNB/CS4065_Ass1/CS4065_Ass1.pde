import static javax.swing.JOptionPane.*;
 
void setup() {
  size(800,600);
  noStroke();
}

boolean gotID = false;
void draw() {
  while (!gotID){
    final String id = showInputDialog("Please enter new User ID");
    if (id == null) {
      exit();
    }
    else if ("".equals(id)){
      showMessageDialog(null, "Empty User ID Input!", "Alert", ERROR_MESSAGE);
    }
    else {
      showMessageDialog(null, "User ID \"" + id + "\" successfully logged!\nPress OK to continue.\nThe experiment will start immediantly.", "Logged", INFORMATION_MESSAGE);
      gotID = true;
    }
  }
  
  background(126);
  ellipse(mouseX, mouseY, 33, 33);
}

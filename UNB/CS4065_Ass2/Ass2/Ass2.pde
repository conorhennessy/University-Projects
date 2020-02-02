int shapeID = 0; 
int moveX, moveY, dragX, dragY;
int strokeWeight = 5;
int red, green, blue; 
ArrayList<int[]> shapes = new ArrayList<int[]>();

void setup() {
  size(1000, 600);
  textSize(28);
}


//TODO 
// get freeform lines to work.
// diferenciation for left & right click, as right click for guestures.

void draw() {
  background(255);
  
  fill(0, 102, 153);
  text("Shape: " + shapeID, width - 250, 30); 
  text("Colour: "+ red + ", " + green + ", " + blue, width - 250, 60);
  text("Weight: " + strokeWeight, width - 250, 90); 

  for (int i = 0; i < shapes.size(); i++) {
    fill(shapes.get(i)[6], shapes.get(i)[7], shapes.get(i)[8]);
    stroke(shapes.get(i)[6]-100, shapes.get(i)[7]-100, shapes.get(i)[8]-100);
    strokeWeight(shapes.get(i)[5]);

    if(shapes.get(i)[0] == 1) {
      rect(shapes.get(i)[1], shapes.get(i)[2], shapes.get(i)[3], shapes.get(i)[4]);
    } else if (shapes.get(i)[0] == 2) {
      ellipseMode(CORNER);
      ellipse(shapes.get(i)[1], shapes.get(i)[2], shapes.get(i)[3], shapes.get(i)[4]);
    } else if (shapes.get(i)[0] == 3) {
      line(shapes.get(i)[1], shapes.get(i)[2], shapes.get(i)[3], shapes.get(i)[4]);
    }
  }
   
  if (dragX != 0 || dragY != 0) {
    fill(red, green, blue);
    stroke(red-100, green-100, blue-100);
    strokeWeight(strokeWeight);
    
    if (shapeID == 1) {
      rect(moveX, moveY, dragX - moveX, dragY - moveY);
    } else if (shapeID == 2) {
      ellipseMode(CORNER);
      ellipse(moveX, moveY, dragX - moveX, dragY - moveY);
    } else if (shapeID == 3) {
      line(moveX, moveY, dragX, dragY);
    }
  }
}

void keyPressed() {
  if (key == 'r') {
    shapeID = 1;
  } else if (key == 'o') {
    shapeID = 2;
  } else if (key == 'l') {
    shapeID = 3;
  } else if (key == 'f') {
    shapeID = 4;
  }
  
  if (key == '1') {
    strokeWeight = 1;
  } else if (key == '2') {
    strokeWeight = 5;
  } else if (key == '3') {
    strokeWeight = 10;
  }
  
  if (key == '!') {
    //black
    red = 0;
    green = 0;
    blue = 0;
  } else if (key == '@') {
    //red
    red = 255;
    green = 0;
    blue = 0;
  } else if (key == '#') {
    //green
    red = 0;
    green = 255;
    blue = 0;
  } else if (key == '$') {
    //blue
    red = 0;
    green = 0;
    blue = 255;
  }
  
  if (key == BACKSPACE && shapes.size() >= 1) {
    shapes.remove(shapes.size() - 1);
  }
}

void mouseMoved() {
  if (shapeID != 0) {
    moveX = mouseX;
    moveY = mouseY;
  }
}

void mouseDragged() {
  if (shapeID != 0) {
    dragX = mouseX;
    dragY = mouseY;
  }
}

void mouseReleased() {
  // To deal with the diffrent format of second point co-cords for a line
  int secondPointX, secondPointY;
  if (shapeID == 3) {
    secondPointX = dragX;
    secondPointY = dragY;
  } else {
    secondPointX = dragX - moveX;
    secondPointY = dragY - moveY;
  }
  
  int[] shape = {shapeID, moveX, moveY, secondPointX, secondPointY, strokeWeight, red, green, blue};
  shapes.add(shape);

  dragX = 0;
  dragY = 0;
  moveX = 0;
  moveY = 0;
}

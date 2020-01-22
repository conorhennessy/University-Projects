import processing.sound.*;
import static javax.swing.JOptionPane.*;

boolean gotID = false;
String id;
long start;
SoundFile[] files;

void setup() {
    frame.setTitle("CS4065 - Targeting System - Assignment 1 (Conor Hennessy)");
    background(157, 171, 134);
    size(1000, 750);
    textSize(25);
    textAlign(CENTER, CENTER);
    fill(255);
    noStroke();
    
    files = new SoundFile[3];
    for (int i = 0; i < files.length; i++) {
        files[i] = new SoundFile(this, (i + 1) + ".wav");
    }
    
    while (!gotID) {
      id = showInputDialog("Please enter your User ID number:");
      if (id == null) {
          break;
      } else if ("".equals(id)) {
          showMessageDialog(null, "Empty User ID number input!\nPlease try again.", "Alert", ERROR_MESSAGE);
      } else {
        gotID = true;
      }
    }
    if(!gotID)
      exit();
      
    start = System.nanoTime();
}

int trialCount = 1;
int blockCount = 1;
boolean nowStart = true;
boolean nowBreak = false;
boolean nowEnd = false;
boolean entrySound = true;
float timer;

void draw() {
    background(157, 171, 134);

    if (nowStart) {
        text("Click to begin!", width / 2, height / 2);
    } else if (nowBreak) {
        fill(255);
        text("Block " + blockCount + " complete!\nTake a break. Click to continue, when ready.", width / 2, height / 2);
    } else if (nowEnd) {
        fill(255);
        text("Block " + blockCount + " complete!\nThe experiment has now completed. Thank you for participating :D", width / 2, height / 2);
    } else {
        if (trialCount <= 10) {
            rect(x, 0, randWidth, height);
        }
                
        if (mouseX >= x && mouseX <= x + randWidth) {
            fill(235, 130, 65);
            if (entrySound) {
               //Play entry sound
               files[0].play(0.8, 1.0);
               entrySound = false;
            }
        } else {
            fill(255, 255, 255);
            entrySound = true;
        }
    }
}

int errorCount = 0;
float elapsedTime;
float previousTime;
int targetDistance;

void mousePressed() {
    if (nowStart) {
        moveRect();
        nowStart = false;
    } else if (nowBreak) {
        moveRect();
        blockCount++;
        trialCount = 1;
        nowBreak = false;
    } else if (mouseX >= x && mouseX <= x + randWidth) {
        timer = System.nanoTime() - start;
        elapsedTime = (timer - previousTime) / 1000000;
        previousTime = timer;
        System.out.printf("%s\t%d\t%d\t%d\t%d\t%.3f\t%d\t\n", id, blockCount, trialCount, randWidth, targetDistance, elapsedTime, errorCount);

        //Play click sound
        files[1].play(0.8, 1.0);
        if (trialCount < 10) {
            moveRect();
            trialCount++;
            errorCount = 0;
        } else if (blockCount < 10) {
            nowBreak = true;
        } else {
            nowEnd = true;
        }
    } else {
        errorCount++;
        //Play error sound
        files[2].play(0.8, 1.0);
    }
}

public int randWidth;
public int x;
public boolean leftTurn = true;

void moveRect() {
    if (leftTurn) {
        x = (int)(Math.random() * ((width / 2 - 0) + 1)) + 0;
        leftTurn = false;
    } else {
        x = (int)(Math.random() * ((width - width / 2) + 1)) + width / 2;
        leftTurn = true;
    }

    randWidth = (int)(Math.random() * ((100 - 10) + 1)) + 10;
    if (x + randWidth >= width) {
        randWidth = (int)(Math.random() * (((width - x) - 10) + 1)) + 10;
    }
    
    targetDistance = leftTurn ? ((x + randWidth) - mouseX) : (mouseX - x);
}

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class AccelerometerListener implements SensorEventListener {
  public void onSensorChanged(SensorEvent event) {
    ax = event.values[0];
    ay = event.values[1];
    az = event.values[2];
  }
  public void onAccuracyChanged(Sensor sensor, int accuracy) {
  }
}

float INITIALCURSORX, INITIALCURSORY;

Context context;
SensorManager manager;
Sensor sensor;
AccelerometerListener listener;

boolean drawCursor = false;
Keyboard tiltKeyboard;
State experimentState;
String msg = "";

float ax, ay, az;
float cursorX, cursorY, keyboardPos;
float tiltSpeed = 1;
float gravity = 9.8;
void setup() {
  fullScreen();
  textFont(createFont("SansSerif", 40 * displayDensity));
  fill(0);
  INITIALCURSORX =width/2;
  INITIALCURSORY = 0.85*height;
  keyboardPos = 0.7*height;
  tiltKeyboard = new Keyboard(width, height);
  context = getActivity();
  manager = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
  sensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
  listener = new AccelerometerListener();
  manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_GAME);
  tiltSpeed = width/(8*gravity);//1 second to go from the center to the side
  experimentState = new State();
}    

void draw() {
  background(255);
  fill(0);
  tiltKeyboard.keyboardDraw();
  experimentState.drawTest();
  if (drawCursor)
  {
    drawTiltCursor();
  }
}

void mousePressed() {
  if (experimentState.tiltRayOn)
  {
    drawCursor = true;
    cursorX = INITIALCURSORX;
    cursorY = INITIALCURSORY;
  }
}

void mouseReleased() {
  // run script on keyboard to find the key pressed
  drawCursor = false;
  if(experimentState.tiltRayOn)
    experimentState.keyInput(tiltKeyboard.detectKey(cursorX, cursorY));
  else if(mouseY > keyboardPos)
    experimentState.keyInput(tiltKeyboard.detectKey(mouseX, mouseY));
}

void drawTiltCursor()
{
    cursorX -= ax*tiltSpeed;
    cursorY = Math.max(mouseY, keyboardPos);
    cursorX = Math.max(cursorX, 0);
    cursorX = Math.min(cursorX, width);
    fill(255);
    circle(cursorX, cursorY, 100);
    fill(255, 0, 0);
    circle(cursorX, cursorY, 10);
}

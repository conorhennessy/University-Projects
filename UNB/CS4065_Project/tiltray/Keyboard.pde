
import java.util.Collections; 
public class Keyboard{
/*
  TODO
  Establish the tiltRay keyboard. It will cover 30% of the height.
  for the keys it will be based on the gboard, where 10 keys form a row, so every square hava a size of width/10
  rules
  normal keys = 1x size
  special keys (enter, shift, delete, change to number keyboard) = 1.5x size
  spacebar = 4x size (in reality, whatever is left after the distribution on the lower bar)
  q w e r t y u i o p
   a s d f g h j k l
  sh z x c v b n m <-              sh  shift       <- delete
  ## , * spaceba . en              ##  numbers     * emojis        en enter
*/
  ArrayList<String> lettersFstCol, lettersSndCol, lettersTrdCol, FthCol, specialFstCol, specialSndCol, specialTrdCol;
  ArrayList<Float> fstColPos, sndColPos, trdColPos, fthColPos;
  boolean capsOn = false, persistenceCaps = false, specialKeys = false;
  float keyboardHeight, keyboardWidth;
  PFont keyboardFont;
  
  public Keyboard(){
    keyboardFont = createFont("Arial",24*displayDensity,true);
    
    capsOn = false;
    persistenceCaps = false;
    specialKeys = false;
    
    lettersFstCol = new ArrayList<String>();
    lettersFstCol.add("q");
    lettersFstCol.add("w");
    lettersFstCol.add("e");
    lettersFstCol.add("r");
    lettersFstCol.add("t");
    lettersFstCol.add("y");
    lettersFstCol.add("u");
    lettersFstCol.add("i");
    lettersFstCol.add("o");
    lettersFstCol.add("p");
    lettersSndCol = new ArrayList<String>();
    lettersSndCol.add("a");
    lettersSndCol.add("s");
    lettersSndCol.add("d");
    lettersSndCol.add("f");
    lettersSndCol.add("g");
    lettersSndCol.add("h");
    lettersSndCol.add("j");
    lettersSndCol.add("k");
    lettersSndCol.add("l");
    lettersTrdCol = new ArrayList<String>();
    lettersTrdCol.add("sh");
    lettersTrdCol.add("z");
    lettersTrdCol.add("x");
    lettersTrdCol.add("c");
    lettersTrdCol.add("v");
    lettersTrdCol.add("b");
    lettersTrdCol.add("n");
    lettersTrdCol.add("m");
    lettersTrdCol.add("del");
    FthCol = new ArrayList<String>();
    FthCol.add("num");
    FthCol.add(",");
    FthCol.add(" ");
    FthCol.add(" ");
    FthCol.add(".");
    FthCol.add("en");
    specialFstCol = new ArrayList<String>();
    specialFstCol.add("1");
    specialFstCol.add("2");
    specialFstCol.add("3");
    specialFstCol.add("4");
    specialFstCol.add("5");
    specialFstCol.add("6");
    specialFstCol.add("7");
    specialFstCol.add("8");
    specialFstCol.add("9");
    specialFstCol.add("0");
    specialSndCol = new ArrayList<String>();
    specialSndCol.add("@");
    specialSndCol.add("#");
    specialSndCol.add("$");
    specialSndCol.add("_");
    specialSndCol.add("&");
    specialSndCol.add("-");
    specialSndCol.add("+");
    specialSndCol.add("(");
    specialSndCol.add(")");
    specialSndCol.add("/");
    specialTrdCol = new ArrayList<String>();
    specialTrdCol.add("sh");
    specialTrdCol.add("*");
    specialTrdCol.add("\"");
    specialTrdCol.add("\'");
    specialTrdCol.add(":");
    specialTrdCol.add(";");
    specialTrdCol.add("!");
    specialTrdCol.add("?");
    specialTrdCol.add("del");
  }
  
  public Keyboard(int screenWidth, int screenHeigth)
  {
    this();
    float keySize = screenWidth/10;
    keyboardHeight = (0.3*screenHeigth);
    keyboardWidth = screenWidth;
    fstColPos = new ArrayList<Float>();
    fstColPos.add(keySize);
    fstColPos.add(2*keySize);
    fstColPos.add(3*keySize);
    fstColPos.add(4*keySize);
    fstColPos.add(5*keySize);
    fstColPos.add(6*keySize);
    fstColPos.add(7*keySize);
    fstColPos.add(8*keySize);
    fstColPos.add(9*keySize);
    fstColPos.add(10*keySize);
    sndColPos = new ArrayList<Float>();
    sndColPos.add((1.5*keySize));
    sndColPos.add((2.5*keySize));
    sndColPos.add((3.5*keySize));
    sndColPos.add((4.5*keySize));
    sndColPos.add((5.5*keySize));
    sndColPos.add((6.5*keySize));
    sndColPos.add((7.5*keySize));
    sndColPos.add((8.5*keySize));
    sndColPos.add(10*keySize);
    trdColPos = new ArrayList<Float>();
    trdColPos.add((1.5*keySize));
    trdColPos.add((2.5*keySize));
    trdColPos.add((3.5*keySize));
    trdColPos.add((4.5*keySize));
    trdColPos.add((5.5*keySize));
    trdColPos.add((6.5*keySize));
    trdColPos.add((7.5*keySize));
    trdColPos.add((8.5*keySize));
    trdColPos.add(10*keySize);
    fthColPos = new ArrayList<Float>();
    fthColPos.add((1.5*keySize));
    fthColPos.add((2.5*keySize));
    fthColPos.add((3.5*keySize));
    fthColPos.add((7.5*keySize));
    fthColPos.add((8.5*keySize));
    fthColPos.add(10*keySize);
  }
  
  public void keyboardDraw(){
    for(int x = 0; x < 4; x++){
      ArrayList<Float> arr;
      ArrayList<String> arrx;
      if(x == 1){
        arr = trdColPos;
        arrx = specialKeys?specialTrdCol:lettersTrdCol;
      }
      else if(x == 2){
        arr = sndColPos;
        arrx = specialKeys?specialSndCol:lettersSndCol;
      }
      else if(x == 3){
        arr = fstColPos;
        arrx = specialKeys?specialFstCol:lettersFstCol;
      }
      else{
        arr = fthColPos;
        arrx = FthCol;
      }
      float stPos = 0;
      for(int y = 0; y < arr.size(); y++)
      {
        fill(255, 255, 255);
        //background(100, 100, 100);
        float wd = (y == 0?arr.get(y):arr.get(y) - arr.get(y-1));
        float hg = keyboardHeight/4;
        rect(stPos, height - keyboardHeight/4*(x+1), wd, hg);
        textFont(keyboardFont);
        fill(0);
        if(!specialKeys && arrx.get(y).length() == 1 && arrx.get(y).charAt(0) > 96 && arrx.get(y).charAt(0) < 123)
          text((char)(arrx.get(y).charAt(0) - (capsOn?32:0)), stPos + wd/2, height - keyboardHeight/4*(x+1) + hg/2);
        else
          text(arrx.get(y), stPos + wd/2, height - keyboardHeight/4*(x+1) + hg/2); 
        stPos = arr.get(y);
      }
    }
  }
  public String detectKey(float x, float y)
  {
    int pos = 0;
    String retVal  = "";
    boolean capsPressed = false;
    if(y < 0.775*height){
      for(pos = 0; pos < fstColPos.size(); pos++)
        if(fstColPos.get(pos) >= x)
          break;
      retVal = specialKeys?specialFstCol.get(pos):lettersFstCol.get(pos);
    }
    else if(y < 0.85*height){
      for(pos = 0; pos < sndColPos.size(); pos++)
        if(sndColPos.get(pos) >= x)
          break;
      retVal = specialKeys?specialSndCol.get(pos):lettersSndCol.get(pos);
    }
    else if(y < 0.925*height){
      for(pos = 0; pos < trdColPos.size(); pos++)
        if(trdColPos.get(pos) >= x)
          break;
      retVal = specialKeys?specialTrdCol.get(pos):lettersTrdCol.get(pos);
      if(pos == 0)
      {
        capsPressed = true;
        if(!persistenceCaps){
          persistenceCaps = capsOn;
          capsOn = true;
        }
        else{
          persistenceCaps = false;
          capsOn = false;
        }
      }
      if(pos == 9)
      {
        //delete(?)
      }
    }
    else{
      for(pos = 0; pos < fthColPos.size(); pos++)
        if(fthColPos.get(pos) >= x)
          break;
      retVal = FthCol.get(pos);
      if(pos == 0)
      {
        specialKeys = !specialKeys;
      }
      if(pos == 9)
      {
        //enter(?)
      }
    }
    if(retVal.length() == 1 && retVal.charAt(0) > 96 && retVal.charAt(0) < 123)
    {
      retVal = String.valueOf((char)(retVal.charAt(0) - (capsOn?32:0)));
    }
    if(!capsPressed)
      capsOn = persistenceCaps;
    return retVal;
  }
}

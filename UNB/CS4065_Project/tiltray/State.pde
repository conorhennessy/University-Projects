
public class State{
  static final int MAX_BLOCKS = 4;
  static final int TEST_NUMBERS = 2;
  static final int MAX_WORDS = 10;
  int stateCode; //0 initial, 1 rest, 2 mid-test, 3 end
  int block, test, wordNumber;
  String id = "";
  PFont stateFont;
  String word = "test";
  String input;
  boolean tiltRayOn;
  State(){
    stateCode = 0;
    stateFont = createFont("SansSerif", 24 * displayDensity);
    input = "";
    tiltRayOn = false;
    block = 0;
    test = 0;
    wordNumber = 0;
  }
  
  public void drawTest(){
    textFont(stateFont);
    fill(0);
    color(0);
    switch(stateCode)
    {
      case 0:
        text("Input your ID", 0.5*width, 0.3*height);
        text(id, 0.5*width, 0.5*height);
        break;
      case 1:
        if(block == 0)
          text("Test round\nPress enter to start", 0.5*width, 0.3*height);
        else
          text("Experiment round "+ block + "\nPress enter to start", 0.5*width, 0.3*height);
        break;
      case 2:
        text(word, 0.5*width, 0.3*height);
        text(input, 0.5*width, 0.5*height);
        break;
      case 3:
        text("Thanks for your time", 0.5*width, 0.3*height);
        break;
      default:
      
    }
    textAlign(CENTER);
  }
  
  public void keyInput(String keys)
  {
    switch(stateCode)
    {
      case 0:
        if(keys.length() == 1 && keys.charAt(0) >= 48 && keys.charAt(0) <= 57)
          id += keys;
        else if (keys == "en"){
          stateCode = 1;
          int chk = Integer.parseInt(id);
          tiltRayOn = (chk&1) == 1;
        }
        else if (keys == "del" && id.length() > 0)
          id = id.substring(0, id.length() - 1);
        break;
      case 1:
        if(keys == "en")
         {
           stateCode = 2;
         }
        break;
      case 2:
        if(keys.length() == 1 && keys.charAt(0) >= 32 && keys.charAt(0) <= 126)
           input += keys;
         else if (keys == "del" && input.length() > 0)
           input = input.substring(0, input.length() - 1);
         validateWord();
        break;
      default:
    }
  }
  public void validateWord()
  {
    //TODO:
    if(word.compareTo(input) == 0)
    {
      //TODO: logic for changing the word goes here
      wordNumber++;
      input = "";
    }
    if(wordNumber == MAX_WORDS)
    {
      //TODO: Time and error number logic goes here
      wordNumber = 0;
      block++;
      stateCode = 1;
    }
    if(block == MAX_BLOCKS)
    {
      block = 0;
      test++;
      tiltRayOn = !tiltRayOn;
    }
    if(test == TEST_NUMBERS)
    {
      stateCode = 3;
    }
  }
} 

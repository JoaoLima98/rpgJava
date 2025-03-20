package systems;
public class Dice {
  int max = 8;
  int min = 1;
  int range = max - min + 1;
  int dice;
  int minStatus = 1;
  int maxStatus = 8;
  int minLP = 10;
  int maxLP = 80;
  int rangeStatus = maxStatus - minStatus + 1;
  int rangeLP = maxLP - minLP + 1;

  public int roll(){
    dice = (int) (Math.random() * range) + min;
    return dice;
  }
  public int rollStatus(){
    dice = (int) (Math.random() * rangeStatus) + minStatus;
    return dice;
  }
  public int rollLP(){
    dice = (int) (Math.random() * rangeLP) + minLP;
    return dice;
  }
}

package systems;
public class Dice {
  int max = 8;
  int min = 1;
  int range = max - min + 1;
  int dice;
  int maxStatus = 3;
  int minLP = 10;
  int maxLP = 80;
  int rangeStatus = maxStatus - min + 1;
  int rangeLP = maxLP - minLP + 1;
  int maxDam = 5;
  int rangeDam = maxDam - min + 1;

  public int roll(){
    dice = (int) (Math.random() * range) + min;
    return dice;
  }
  public int rollStatus(){
    dice = (int) (Math.random() * rangeStatus) + min;
    return dice;
  }
  public int rollLP(){
    dice = (int) (Math.random() * rangeLP) + minLP;
    return dice;
  }
  public int rollDamage(){
    dice = (int) (Math.random() * rangeDam) + min;
    return dice;
  }
}

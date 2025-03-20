package enemies;
import characters.Character;

public class Slime extends Character{
  public Slime (int lp, int attack, int defense){
    super("Slime", 140+lp, 12+attack, 15+defense, 0, 70);
  }
}

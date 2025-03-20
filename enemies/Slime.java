package enemies;
import characters.Character;

public class Slime extends Character{
  public Slime (int lp, int attack, int defense){
    super("Slime", 120+lp, 6+attack,30+defense, 0, 30);
  }
}

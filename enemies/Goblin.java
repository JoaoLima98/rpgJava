package enemies;
import characters.Character;

public class Goblin extends Character{
  public Goblin(int lp, int attack, int defense){
    super("Goblin", 120+lp, 20+attack,10+defense, 0, 50);
  }

}

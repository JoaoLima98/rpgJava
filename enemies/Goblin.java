package enemies;
import characters.Character;

public class Goblin extends Character{
  public Goblin(int lp, int attack, int defense){
    super("Goblin", 120+lp, 23+attack,13+defense, 0, 100);
  }

}

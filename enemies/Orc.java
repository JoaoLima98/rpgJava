package enemies;
import characters.Character;

public class Orc extends Character{

  public Orc (int lp, int attack, int defense){
    super("Orc", 150+lp, 30+attack,15+defense, 0, 80);
  }
}

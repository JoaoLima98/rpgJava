package enemies;
import characters.Character;

public class Harpy extends Character {
  public Harpy (int lp, int attack, int defense){
    super("Harpia", 150+lp, 25+attack,15+defense, 0, 100);
  }
}

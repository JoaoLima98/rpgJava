package enemies;
import characters.Character;

public class Bandit extends Character {
  public Bandit(int lp, int attack, int defense){
    super("Bandido", 180+lp, 35+attack, 15+defense, 1, 200);
  }
}

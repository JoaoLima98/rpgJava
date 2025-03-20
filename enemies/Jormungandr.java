package enemies;
import characters.Character;

public class Jormungandr extends Character{
  public Jormungandr(int lp, int attack, int defense){
    super("Jörmungandr", 500+lp, 50+attack, 50+defense, 0, 0);
  }
}

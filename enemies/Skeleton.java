package enemies;
import characters.Character;

public class Skeleton extends Character{
  public Skeleton (int lp, int attack, int defense){
    super("Esqueleto", 150+lp, 20+attack,8+defense, 0, 50);
  }
}
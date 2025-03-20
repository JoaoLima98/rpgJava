package enemies;
import characters.Character;

public class Skeleton extends Character{
  public Skeleton (int lp, int attack, int defense){
    super("Esqueleto", 150+lp, 18+attack,5+defense, 0, 50);
  }
}
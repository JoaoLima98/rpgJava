package enemies;
import characters.Character;

public class Skeleton extends Character{
  public Skeleton (int lp, int attack, int defense){
    super("Esqueleto", 100+lp, 30+attack,5+defense, 0, 30);
  }
}
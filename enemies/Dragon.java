package enemies;
import characters.Character;

public class Dragon extends Character{
  public Dragon(int lp, int attack, int defense){
    super("Dragão", 300+lp, 50+attack,30+defense, 0, 300);
  }
}

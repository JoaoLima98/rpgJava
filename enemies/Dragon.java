package enemies;
import characters.Character;

public class Dragon extends Character{
  public Dragon(int lp, int attack, int defense){
    super("Dragão", 300+lp, 40+attack, 25+defense, 0, 300);
  }
}

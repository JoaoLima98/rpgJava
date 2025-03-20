package characters;
public class Paladin extends Character {
  public Paladin(String name, int lp, int attack, int defense){
    super(name, 200+lp, 20+attack, 17+defense, 1, 50);
  }
}

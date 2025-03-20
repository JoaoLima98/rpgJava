package characters;
public class Mage extends Character {
  public Mage (String name, int lp, int attack, int defense){
    super(name, 100+lp, 30+attack, 10+defense, 3, 100);
  }
}

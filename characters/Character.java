
package characters;

import systems.ConsoleManager;
import systems.Dice;

public class Character {
  private String name;
  private int lifePoints;
  private int attack;
  private int defense;
  private int originalDefense;
  private int originalAttack;
  private int originalLP;
  private int potions;
  private int money;
  private boolean poisonEffect = false;
  private int attackBuffTurns = 0;
  private int defenseBuffTurns = 0;
  private double buffValues = 0.1;

  Dice dice = new Dice();
  ConsoleManager console = new ConsoleManager();

  public Character (String name, int lifePoints, int attack, int defense, int potions, int money){
    this.name = name;
    this.lifePoints = lifePoints;
    this.attack = attack;
    this.defense = defense;
    this.potions = potions;
    this.originalAttack = attack;
    this.originalDefense = defense;
    this.originalLP = lifePoints;
    this.money = money;
  }
  public void levelUp(){
    this.originalAttack += 1;
    this.originalDefense += 1;
    this.originalLP += 10;

    System.out.println("Você ficou mais forte depois desta batalha!");
    console.consoleGreen("Você recebeu ","+"+10, " de vida");
    console.consoleRed("Você recebeu ","+"+1, " de ataque");
    console.consoleRed("Você recebeu ","+"+1, " de defesa");

  }

  public void restoreStatus(){
    this.defense = originalDefense;
    this.attack = originalAttack;
    System.out.println("Status restaurados");
  }

    /**
     * @return String return the classHero
     */
    public String getName() {
        return name;
    }
    public int getPotions() {
      return potions;
    }

    /**
     * @param name the classHero to set
     */
    public void setClassHero(String name) {
        this.name = name;
    }

    /**
     * @return int return the lifePoints
     */
    public int getLifePoints() {
        return lifePoints;
    }

    /**
     * @param lifePoints the lifePoints to set
     */
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    /**
     * @return int return the attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @param attack the attack to set
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * @return int return the defense
     */
    public int getDefense() {
        return defense;
    }

    /**
     * @param defense the defense to set
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

  public void attackEnemy(Character enemy){
    if(!this.isAlive()){
      return;
    }
    int result = dice.rollDamage();
    int damage = this.attack;
    damage += result;
    damage -= enemy.defense;
    if(result == 5){
      System.out.println(this.name + " ACERTOU UM CRÍTICO!!! LÁ VEM TONELADAS DE DANO \n");
    }
    
    if (damage <= result){
      damage = result;
    }
    enemy.lifePoints -= damage;
    console.consoleRed(this.name + " atacou e causou ", String.valueOf(damage), " de dano ao inimigo\n");
    if(poisonEffect == true){
      enemy.lifePoints -= 5;
      console.consoleRed("O inimigo sofreu ", 2, " de dano de envenenamento");
    }


  }
  public void showStatus(){
    System.out.println("Nome: " + name);
    System.out.println("Ataque: " + attack);
    System.out.println("Defesa: " + defense);
    console.consoleYellow("Moedas: ", money);
    console.consoleGreen("Pontos de vida atuais: ",  lifePoints +"/" + originalLP , "\n");
    System.out.println("Quantidade de poções: " + potions +"\n");

  }
  public void showLP(){
    console.consoleGreen(this.name + " tem ",  lifePoints +"/" + originalLP , " pontos de vida: ");
  }

  public boolean isAlive(){
    if (this.lifePoints <= 0){
      return false;
    }
    return true;
  }

  public void buffAttack(Character enemy){
    if (this.attackBuffTurns > 0){
      System.out.println("Você já está buffado! Você atacará ao invés");
      this.attackEnemy(enemy);
      return;
    }
    int buff = (int) Math.round(this.attack * buffValues);
    this.attack += buff;
    this.attackBuffTurns = 3;
    System.out.println(String.format("Seu attack foi buffado em %.0f%% por dois turnos! Você agora tem ataque de: %d", buffValues * 100, this.attack));

  }

  public void buffDefense(Character enemy){
    int buff = (int) Math.round(this.defense * buffValues);
    if (this.defenseBuffTurns > 0){
      System.out.println("Você já está buffado! Você atacará ao invés");
      this.attackEnemy(enemy);
      return;
    }
    this.defense += buff;
    this.defenseBuffTurns = 3;
    System.out.println(String.format("Sua defesa foi buffada em %.0f%% por dois turnos! Você agora tem defesa de: %d", buffValues * 100, this.defense));
  }

  public void usePotion(Character enemy){
    if (this.potions == 0){
      System.out.println("Sem poções, você atacará ao invés");
      this.attackEnemy(enemy);
      return;
    }

    this.lifePoints += (50 + dice.roll());
    if(lifePoints >= originalLP){
      lifePoints = originalLP;
    }
    console.consoleGreen("Você se curou! Agora seu hp é: ", lifePoints + "/" + originalLP, "\n");
    potions--;
    System.out.println("Agora você tem: " + potions + "poções");
  }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the originalDefense
     */
    public int getOriginalDefense() {
        return originalDefense;
    }

    /**
     * @param originalDefense the originalDefense to set
     */
    public void setOriginalDefense(int originalDefense) {
        this.originalDefense = originalDefense;
    }

    /**
     * @return int return the originalAttack
     */
    public int getOriginalAttack() {
        return originalAttack;
    }

    /**
     * @param originalAttack the originalAttack to set
     */
    public void setOriginalAttack(int originalAttack) {
        this.originalAttack = originalAttack;
    }

    /**
     * @return int return the originalLP
     */
    public int getOriginalLP() {
        return originalLP;
    }

    /**
     * @param originalLP the originalLP to set
     */
    public void setOriginalLP(int originalLP) {
        this.originalLP = originalLP;
    }

    /**
     * @param potions the potions to set
     */
    public void setPotions(int potions) {
        this.potions = potions;
    }


    /**
     * @return int return the money
     */
    public int getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(int money) {
        this.money = money;
    }


    /**
     * @return boolean return the poisonEffect
     */
    public boolean isPoisonEffect() {
        return poisonEffect;
    }

    /**
     * @param poisonEffect the poisonEffect to set
     */
    public void setPoisonEffect(boolean poisonEffect) {
        this.poisonEffect = poisonEffect;
    }



    /**
     * @return int return the attackBuffTurns
     */
    public int getAttackBuffTurns() {
        return attackBuffTurns;
    }

    /**
     * @param attackBuffTurns the attackBuffTurns to set
     */
    public void setAttackBuffTurns(int attackBuffTurns) {
        this.attackBuffTurns = attackBuffTurns;
    }


    /**
     * @return int return the defenseBuffTurns
     */
    public int getDefenseBuffTurns() {
        return defenseBuffTurns;
    }

    /**
     * @param defenseBuffTurns the defenseBuffTurns to set
     */
    public void setDefenseBuffTurns(int defenseBuffTurns) {
        this.defenseBuffTurns = defenseBuffTurns;
    }

    public void resetBuffs(){
      if (this.attackBuffTurns == 0){
        this.attack = this.originalAttack;
      }
      if(this.defenseBuffTurns == 0){
        this.defense = this.originalDefense;
      }
    }
    public void decrementBuffs(){
      if(this.attackBuffTurns > 0){
        this.attackBuffTurns--;
      }
      if(this.defenseBuffTurns > 0){
        this.defenseBuffTurns--;
      }
      resetBuffs();
    }

    public void healAfterBattle(){
      this.lifePoints += (10 + dice.roll());
      if(lifePoints >= originalLP){
        lifePoints = originalLP;
      }
      console.consoleGreen("Você se curou um pouco após a batalha! Agora seu hp é: ", lifePoints + "/" + originalLP, "\n");
    }
    /**
     * @return double return the buffValues
     */
    public double getBuffValues() {
        return buffValues;
    }

    /**
     * @param buffValues the buffValues to set
     */
    public void setBuffValues(double buffValues) {
        this.buffValues = buffValues;
    }
    
}
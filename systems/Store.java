package systems;
import java.util.Scanner;

import characters.Character;

public class Store {
  private int priceStats = 100;
  private int priceFullHeal = 80;
  Scanner scanner = new Scanner(System.in);
  ConsoleManager console = new ConsoleManager();

  public void increaseMaxLP(Character player){
    player.setOriginalLP(player.getOriginalLP()+50);
    player.setLifePoints(player.getLifePoints()+25);
  }
  public void increaseAttack(Character player){
    player.setOriginalAttack(player.getOriginalAttack()+5);
  }
  public void increaseDefense(Character player){
    player.setOriginalDefense(player.getOriginalDefense()+5);
  }
  public void addPotion(Character player){
    player.setPotions(player.getPotions()+1);
  }
  public void poisonEffect(Character player){
    player.setPoisonEffect(true);
  }
  public void increaseBuff(Character player){
    player.setBuffValues(player.getBuffValues()+0.1);
  }
  public boolean checkMoney(Character player, int price){
    if(player.getMoney() < price){
      System.out.println("Moedas insuficientes");
      return true;
    }
    System.out.println("Compra realizada com sucesso!");
    return false;
  }
  public void healFullLife(Character player){
    player.setLifePoints(player.getOriginalLP());
  }

  public void openStore(Character player){
    player.setAttackBuffTurns(0);
    player.setDefenseBuffTurns(0);
    System.out.println("Parabéns pela vitória recente! ");
    while (true) {
      console.consoleYellow("Moedas: ", player.getMoney());
      System.out.println("****BEM VINDO A LOJA******");
      System.out.println("Selecione o que deseja: ");
      System.out.println("[1] - Aumentar 50 de HP máximo e curar 25 - "+priceStats+" moedas");
      System.out.println("[2] - Aumentar 5 de ataque - " +priceStats+" moedas");
      System.out.println("[3] - Aumentar 5 de defesa - "+priceStats+" moedas");
      System.out.println("[4] - Comprar poção - 30 moedas");
      System.out.println("[5] - Comprar efeito de veneno (5 de dano por turno) - 150 moedas");
      System.out.println("[6] - Comprar aumento de buffs - 80 moedas");
      System.out.println("[7] - Descansar e restaurar toda vida - " +priceFullHeal+" moedas)");
      System.out.println("[0] - Sair");
      int department = scanner.nextInt();
      scanner.nextLine();
      switch (department) {
        case 1:
              if(checkMoney(player, priceStats)){
                break;
              }
                increaseMaxLP(player);
                player.setMoney(player.getMoney()-priceStats);
                break;
        case 2:
              if(checkMoney(player, priceStats)){
                break;
              }
                increaseAttack(player);
                player.setMoney(player.getMoney()-priceStats);
                break;
        case 3:
              if(checkMoney(player, priceStats)){
                break;
              }
                increaseDefense(player);
                player.setMoney(player.getMoney()-priceStats);
                break;
        case 4:
              if(checkMoney(player, 30)){
                break;
              }
                addPotion(player);
                player.setMoney(player.getMoney()-30);
                break;
        case 5:
              if(checkMoney(player, 150)){
                break;
              }
              poisonEffect(player);
              player.setMoney(player.getMoney()-150);
              break;
        case 6:
              if(checkMoney(player, 80)){
                break;
              }
              increaseBuff(player);
              player.setMoney(player.getMoney()-80);
              break;
        case 7:
              if(checkMoney(player, priceFullHeal)){
                break;
              }
              healFullLife(player);
              player.setMoney(player.getMoney()-priceFullHeal);
              priceFullHeal *= 2;
              break;
        case 0: 
              System.out.println("Obrigado por visitar a loja\n");
              return;
        default:
                System.out.println("Opção não existente.");
                break;
    }
    }
    
  }

}

package systems;
import java.util.Scanner;

import characters.Character;

public class Store {
  
  Scanner scanner = new Scanner(System.in);
  ConsoleManager console = new ConsoleManager();

  public void increaseMaxLP(Character player){
    player.setOriginalLP(player.getOriginalLP()+50);
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

  public void openStore(Character player){
    player.setAttackBuffTurns(0);
    player.setDefenseBuffTurns(0);
    System.out.println("Parabéns pela vitória recente! ");
    while (true) {
      console.consoleYellow("Moedas: ", player.getMoney());
      System.out.println("****BEM VINDO A LOJA******");
      System.out.println("Selecione o que deseja: ");
      System.out.println("[1] - Aumentar HP máximo - 150 moedas");
      System.out.println("[2] - Aumentar ataque - 100 moedas");
      System.out.println("[3] - Aumentar defesa - 120 moedas");
      System.out.println("[4] - Comprar poção - 80 moedas");
      System.out.println("[5] - Comprar efeito de poção - 200 moedas");
      System.out.println("[6] - Comprar aumento de buffs - 110 moedas");
      System.out.println("[7] - Sair");
      int department = scanner.nextInt();
      scanner.nextLine();
      switch (department) {
        case 1:
              if(checkMoney(player, 150)){
                break;
              }
                increaseMaxLP(player);
                player.setMoney(player.getMoney()-150);
                break;
        case 2:
              if(checkMoney(player, 100)){
                break;
              }
                increaseAttack(player);
                player.setMoney(player.getMoney()-100);
                break;
        case 3:
              if(checkMoney(player, 120)){
                break;
              }
                increaseDefense(player);
                player.setMoney(player.getMoney()-120);
                break;
        case 4:
              if(checkMoney(player, 80)){
                break;
              }
                addPotion(player);
                player.setMoney(player.getMoney()-80);
                break;
        case 5:
              if(checkMoney(player, 80)){
                break;
              }
              poisonEffect(player);
              player.setMoney(player.getMoney()-200);
              break;
        case 6:
              if(checkMoney(player, 110)){
                break;
              }
              increaseBuff(player);
              player.setMoney(player.getMoney()-110);
              break;
        case 7: 
              System.out.println("Obrigado por visitar a loja");
              return;
        default:
                System.out.println("Opção não existente.");
                break;
    }
    }
    
  }

}

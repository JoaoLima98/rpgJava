package systems;
import java.util.Scanner;

import characters.Character;

public class BattleSystem {
  ConsoleManager clean = new ConsoleManager();
  Scanner scanner = new Scanner(System.in);
  Store store = new Store();
  
  public boolean battle(Character player, Character enemy, boolean play){
    System.out.println("Você está enfrentando " + enemy.getName());
    while (player.isAlive() && enemy.isAlive()) {
      int chosen;
      clean.consoleGreen(enemy.getName() + " tem ", enemy.getLifePoints() + "/" +enemy.getOriginalLP(), " de HP\n");
      System.out.println("Escolha seu movimento: [1] Ataque - [2] Buffar ataque - [3] - Buffar defesa - [4] - Usar poção");

      chosen = scanner.nextInt();
      switch (chosen) {
      case 1:
             clean.clean();
             player.attackEnemy(enemy);
             break;
      case 2:
             clean.clean();
             player.buffAttack(enemy);
             break;
      case 3:
             clean.clean();
             player.buffDefense(enemy);
             break;
      case 4:
            clean.clean();
            player.usePotion(enemy);
            break;
      default:
             clean.clean();
             System.out.println("Escolha inválida! Definindo como Ataque por padrão.");
             player.attackEnemy(enemy);
             break;
      }   
      
      enemy.attackEnemy(player);
      player.decrementBuffs();
      if (player.getLifePoints() <= 0){
        System.out.println(player.getName() + " Morreu \n" + enemy.getName()+ " Venceu\n");
        System.out.println("Deseja jogar novamente? [1] - Sim [2] - Não");
        int response = scanner.nextInt();
        if (response != 1){
          return false;
        }
      }
   
     if (enemy.getLifePoints() <= 0) {
       System.out.println(enemy.getName() + " Morreu\n" + player.getName()+ " Venceu\n");
       player.setMoney(player.getMoney() + enemy.getMoney());
       player.restoreStatus();
       player.healAfterBattle();
       store.openStore(player);
       player.restoreStatus();
      }

    }
 return true;
  }
  
}

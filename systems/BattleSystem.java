package systems;
import java.util.Scanner;

import characters.Character;

public class BattleSystem {
  ConsoleManager console = new ConsoleManager();
  Scanner scanner = new Scanner(System.in);
  Store store = new Store();


  public boolean battle(Character player, Character enemy, boolean play){
    System.out.println("Você está enfrentando " + enemy.getName());
    while (player.isAlive() && enemy.isAlive()) {
      player.showStatus();
      System.out.println("-------------------");
      int chosen;
      enemy.showStatus();
      System.out.println("Escolha seu movimento: [1] Ataque - [2] Buffar ataque - [3] - Buffar defesa - [4] - Usar poção");

      chosen = scanner.nextInt();
      switch (chosen) {
      case 1:
             console.clean();
             player.attackEnemy(enemy);
             break;
      case 2:
             console.clean();
             player.buffAttack(enemy);
             break;
      case 3:
             console.clean();
             player.buffDefense(enemy);
             break;
      case 4:
            console.clean();
            player.usePotion(enemy);
            break;
      
      default:
             console.clean();
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
       console.consoleYellow("Você recebeu: ", enemy.getMoney(), " de moedas por derrotar" + enemy.getName());
       player.restoreStatus();
       player.levelUp();
       player.healAfterBattle();
       store.openStore(player);
       player.restoreStatus();
      }

    }
 return true;
  }
  
}

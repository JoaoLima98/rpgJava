import java.util.Scanner;

import characters.Character;
import characters.Knight;
import characters.Mage;
import characters.Paladin;
import enemies.*;
import systems.BattleSystem;
import systems.Dice;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BattleSystem battle = new BattleSystem();
    Dice dice = new Dice();

    boolean play = true;

       while (play) {
              System.out.println("Escolha seu nome: ");
              String name = scanner.nextLine();

              System.out.println("Escolha seu personagem: [1] = Cavaleiro, [2] = Mago, [3] = Paladino");

              int chosen = scanner.nextInt();
              scanner.nextLine();
              Character player;
              Character[] enemies = {
                     new Rats(dice.rollLP(), dice.rollStatus(), dice.rollStatus()),
                     new Slime(dice.rollLP(), dice.rollStatus(), dice.rollStatus()),
                     new Skeleton(dice.rollLP(), dice.rollStatus(), dice.rollStatus()),
                     new Goblin(dice.rollLP(), dice.rollStatus(), dice.rollStatus()),
                     new Harpy(dice.rollLP(), dice.rollStatus(), dice.rollStatus()),
                     new Orc(dice.rollLP(), dice.rollStatus(), dice.rollStatus()),
                     new Bandit(dice.rollLP(), dice.rollStatus(), dice.rollStatus()),
                     new Dragon(dice.rollLP(), dice.rollStatus(), dice.rollStatus())
              };
              

              switch (chosen) {
              case 1:
                     player = new Knight(name, dice.rollLP(), dice.rollStatus(), dice.rollStatus());
                     break;
              case 2:
                     player = new Mage(name, dice.rollLP(), dice.rollStatus(), dice.rollStatus());

                     break;
              case 3:
                     player = new Paladin(name, dice.rollLP(), dice.rollStatus(), dice.rollStatus());
                     break;
              default:
                     System.out.println("Escolha inválida! Definindo como Guerreiro por padrão.");
                     player = new Knight(name, dice.rollLP(), dice.rollStatus(), dice.rollStatus());
                     break;
              }

              player.showStatus();
              
              for (Character enemy : enemies) {
                     play = battle.battle(player, enemy, play);
                     if (!play) break;
              }
       }
    
}
}

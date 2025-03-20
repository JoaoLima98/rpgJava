package systems;
public class ConsoleManager {
  private static final String GREEN_TEXT = "\u001B[32m";
  private static final String YELLOW_TEXT = "\u001B[33m";
  private static final String RED_TEXT = "\u001B[31m";
  private static final String RESET = "\u001B[0m";
  private String prefix = ""; // Inicializa prefix com uma string vazia
    private String sufix = "";

  public void clean(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public void consoleGreen(String prefix, String x, String sufix) {
      System.out.println(prefix + GREEN_TEXT + x + RESET + sufix);
  }

  public void consoleGreen(String x) {
      consoleGreen(this.prefix, x, this.sufix);
  }

  public void consoleGreen(String x, String sufix) {
      consoleGreen(this.prefix, x, this.sufix);
  }

  public void consoleGreen(String prefix, int x, String sufix) {
      System.out.println(prefix + GREEN_TEXT + x + RESET + sufix);
  }

  public void consoleGreen(int x) {
      consoleGreen(this.prefix, x, this.sufix);
  }

  public void consoleGreen(int x, String sufix) {
      consoleGreen(this.prefix, x, this.sufix);
  }

  public void consoleGreen(String prefix, int x) {
      consoleGreen(this.prefix, x, this.sufix);
  }

  //RED

  public void consoleRed(String prefix, String x, String sufix) {
      System.out.println(prefix + RED_TEXT + x + RESET + sufix);
  }

  public void consoleRed(String x) {
      consoleRed(this.prefix, x, this.sufix);
  }

  public void consoleRed(String x, String sufix) {
      consoleRed(this.prefix, x, this.sufix);
  }

  public void consoleRed(String prefix, int x, String sufix) {
      System.out.println(prefix + RED_TEXT + x + RESET + sufix);
  }

  public void consoleRed(int x) {
      consoleRed(this.prefix, x, this.sufix);
  }

  public void consoleRed(int x, String sufix) {
      consoleRed(this.prefix, x, this.sufix);
  }

  public void consoleRed(String prefix, int x) {
      consoleRed(this.prefix, x, this.sufix);
  }

  //YELLOW

  public void consoleYellow(String prefix, String x, String sufix) {
      System.out.println(prefix + YELLOW_TEXT + x + RESET + sufix);
  }

  public void consoleYellow(String x) {
      consoleYellow(this.prefix, x, this.sufix);
  }

  public void consoleYellow(String x, String sufix) {
      consoleYellow(this.prefix, x, this.sufix);
  }

  public void consoleYellow(String prefix, int x, String sufix) {
      System.out.println(prefix + YELLOW_TEXT + x + RESET + sufix);
  }

  public void consoleYellow(int x) {
      consoleYellow(this.prefix, x, this.sufix);
  }

  public void consoleYellow(int x, String sufix) {
      consoleYellow(this.prefix, x, this.sufix);
  }

  public void consoleYellow(String prefix, int x) {
      consoleYellow(prefix, x, this.sufix);
  }
  

}
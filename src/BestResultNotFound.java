public class BestResultNotFound extends Exception {
  private String name;

  public BestResultNotFound(String name) {
    super();
    this.name = name;
  }

  @Override
  public String toString() {
    return "BestResultNotFound";
  }
}

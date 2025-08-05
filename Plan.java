public class Plan {
    private final int id;
    private static int nextId = 0;
    private String name;
    private double price;
    private int durationMonths;
    private boolean isActive;

    public Plan(String name, double price, int durationMonths){
        validateName(name);

        this.id = ++nextId;
        this.name = name;
        this.price = price;
        this.durationMonths = durationMonths;
        this.isActive = false;
    }

    private void validateName(String name){
        if (name == null || name.trim().length() < 3){
            throw new IllegalArgumentException("Insert a valid name with three characters or more.");
        }
    }
}

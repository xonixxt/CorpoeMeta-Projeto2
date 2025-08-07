public class Member {
    private final int id;
    private static int nextId = 0;
    private String name;
    private int age;
    private String email;
    private String phone;
    private boolean active;
    private Plan plan;

    public Member(String name, int age, String email, String phone) {
        validateName(name);
        validateAge(age);
        validateEmail(email);
        validatePhone(phone);
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.id = ++nextId;
        this.active = false;
        this.plan = null;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("You must insert a valid name.");
        }
    }

    private void validateAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Insert your true age.");
        }
    }

    private void validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Insert a valid email.");
        }
    }

    private void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\d{11}")) {
            throw new IllegalArgumentException("Insert your number with DDD and without space or symbol");
        }
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public boolean hasPlan() {
        return this.plan != null;
    }

    public void removePlan() {
        this.plan = null;
    }
}

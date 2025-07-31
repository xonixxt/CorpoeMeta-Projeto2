public class Member {
    private final int id;
    private static int nextId = 0;
    private String name;
    private int age;
    private final String email;
    private final String phone;
    private boolean active;

    public Member(String name, int age, String email, String phone){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("You must insert a valid name.");
        }
        this.name = name;

        this.age = age;
        this.email = email;
        this.phone = phone;
        this.id = ++nextId;
        this.active = false;
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
}

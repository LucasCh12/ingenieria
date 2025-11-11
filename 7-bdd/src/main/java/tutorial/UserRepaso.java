package tutorial;

/**
 * Esta clase se realizo para poder repasar el tema, con un programa generico donde debo realizar
 * test gherkin y el glue correspondiente.
 */

public class UserRepaso {
    private int id;
    private String name;
    private String email;
    private int age;

    public UserRepaso(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', email='%s', age=%d}", 
                           id, name, email, age);
    }    
}

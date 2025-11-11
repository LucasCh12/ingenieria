package tutorial;

import java.util.ArrayList;
import java.util.List;

public class UserManagerRepaso {
    private List<UserRepaso> UserRepasos;
    private int nextId;

    public UserManagerRepaso() {
        this.UserRepasos = new ArrayList<>();
        this.nextId = 1;
    }

    public UserRepaso addUserRepaso(String name, String email, int age) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Edad inválida");
        }

        UserRepaso UserRepaso = new UserRepaso(nextId++, name, email, age);
        UserRepasos.add(UserRepaso);
        return UserRepaso;
    }


    public UserRepaso findUserRepasoById(int id) {
        return UserRepasos.stream()
                .filter(UserRepaso -> UserRepaso.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean deleteUserRepaso(int id) {
        return UserRepasos.removeIf(UserRepaso -> UserRepaso.getId() == id);
    }

    public List<UserRepaso> getUserRepasos() {
        return new ArrayList<>(UserRepasos);
    }

    public List<UserRepaso> findUserRepasosByAgeRange(int minAge, int maxAge) {
        List<UserRepaso> result = new ArrayList<>();
        for (UserRepaso UserRepaso : UserRepasos) {
            if (UserRepaso.getAge() >= minAge && UserRepaso.getAge() <= maxAge) {
                result.add(UserRepaso);
            }
        }
        return result;
    }

    public int getUserRepasoCount() {
        return UserRepasos.size();
    }

    public void clearAllUserRepasos() {
        UserRepasos.clear();
        nextId = 1;
    }
}
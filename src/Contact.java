package src;

public record Contact(String name, String number, String email) {

    @Override
    public String toString() {
        return name + "," + number + "," + email;
    }
}


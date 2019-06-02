package sample;

public class Number {
    private String number;
    private LastName location;

    public Number(String number, LastName lastName) {
        this.location=lastName;
        this.number = number;
    }

    public LastName getLocation() {
        return location;
    }

    public String getNumber() {
        return number;
    }
}

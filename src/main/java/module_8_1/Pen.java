package module_8_1;

public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");

        private final String color;

        Color(String color) {
            this.color = color;
        };

        @Override public String toString() {
            return color;
        }
    }

    Color color;
    boolean isCupOff = false;

    public Pen() {
        this.color = Color.RED;
    }

    public Pen(Color color) {
        this.color = color;
    }

    String draw() {
        String result = "";
        if (isCupOff) {
            result = "Drawing " + color;
        }
        return result;
    }

    void capOff() {
        this.isCupOff = true;
    }

    void capOn() {
        this.isCupOff = false;
    }

    void changeColor(Color color) {
        if (!isCupOff) {
            this.color = color;
        }
    }
}

package module_6_3;

public class PetController {
    private Pet pet;
    private double lastStepX = 0;

    public PetController() {
        this.pet = new Pet(100, 100);
    }

    public double getX() {
        return this.pet.getX();
    }

    public double getY() {
        return this.pet.getY();
    }

    public void moveToMouse(double mouseX, double mouseY) {
        // √(x₂-x₁)² + (y₂-y1₁)² on etäisyys kahden pisteen välillä
        double dx = mouseX - this.pet.getX();
        double dy = mouseY - this.pet.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance == 0) {
            return;
        }

        double speed = 3;

        if (distance < speed) {
            this.pet.setPosition(mouseX, mouseY);
        } else {
            double stepX = dx / distance;
            double stepY = dy / distance;
            this.lastStepX = stepX;

            this.pet.setPosition(
                this.pet.getX() + stepX * speed,
                this.pet.getY() + stepY * speed
            );
        }
    }

    public boolean isMovingRight() {
        return lastStepX > 0;
    }

    public boolean isMovingLeft() {
        return lastStepX < 0;
    }
}

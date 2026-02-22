package module_6_3;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;

public class PetView {
    private Canvas canvas;
    private GraphicsContext gc;
    private PetController controller;

    private Image petLeftImage;
    private Image petRightImage;
    private Image backgroundImage;

    private double mouseX;
    private double mouseY;
    private boolean mouseInside = false;

    public PetView(PetController controller) {
        this.controller = controller;
        this.canvas = new Canvas(820, 460);
        this.gc = canvas.getGraphicsContext2D();
        this.petLeftImage = new Image(getClass().getResource("/pet-l.png").toExternalForm());
        this.petRightImage = new Image(getClass().getResource("/pet-r.png").toExternalForm());
        this.backgroundImage = new Image(getClass().getResource("/pet-bg.png").toExternalForm());

        canvas.setOnMouseMoved(e -> {
            mouseX = e.getX();
            mouseY = e.getY();
            mouseInside = true;
        });


        canvas.setOnMouseExited(e -> {
            mouseInside = false;
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (mouseInside) {
                    controller.moveToMouse(mouseX, mouseY);
                    draw();
                }
            }
        };
        timer.start();
    }

    public Canvas create() {
        draw();
        return canvas;
    }

    private void draw() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.drawImage(backgroundImage, 0, 0, canvas.getWidth(), canvas.getHeight());

        Image currentPetImage;
        if (controller.isMovingRight()) {
            currentPetImage = petRightImage;
        } else {
            currentPetImage = petLeftImage;
        }
        gc.drawImage(currentPetImage, controller.getX(), controller.getY(), 40, 40);
    }
}

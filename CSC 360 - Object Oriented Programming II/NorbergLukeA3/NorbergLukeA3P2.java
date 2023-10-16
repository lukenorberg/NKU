import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.Random;

public class NorbergLukeA3P2 extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Stage primaryStage = new Stage();
        Pane pane = new Pane();

        primaryStage.setTitle("Modern Art");

        final int MIN_RECT_SIZE = 10;
        final int MAX_RECT_SIZE = 100;
        final int NUM_OF_RECTS = 50;

        final int SCENE_WIDTH = 600;
        final int SCENE_HEIGHT = 300;

        Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);

        for (int i = 0; i < NUM_OF_RECTS; i++) {
            Random random = new Random();

            int width = random.nextInt((MAX_RECT_SIZE + 1) - MIN_RECT_SIZE) + MIN_RECT_SIZE;
            int height = random.nextInt((MAX_RECT_SIZE + 1) - MIN_RECT_SIZE) + MIN_RECT_SIZE;
            int x = random.nextInt((SCENE_WIDTH + 1) - width);
            int y = random.nextInt((SCENE_HEIGHT + 1) - height);

            Rectangle rectangle = new Rectangle(
                 x,
                 y,
                 width,
                 height
            );

            Color randomColor = new Color(
                    random.nextDouble(),
                    random.nextDouble(),
                    random.nextDouble(),
                    random.nextDouble()
            );

            rectangle.setFill(randomColor);
            pane.getChildren().add(rectangle);
        }

        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}

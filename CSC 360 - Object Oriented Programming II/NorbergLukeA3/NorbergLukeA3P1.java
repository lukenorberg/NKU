import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class NorbergLukeA3P1 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Stage primaryStage = new Stage();
        Pane pane = new Pane();

        primaryStage.setTitle("Smiley Face");

        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setScene(scene);

        Circle head = new Circle();
        final double HEAD_RADIUS = 100.0;

        head.setRadius(HEAD_RADIUS);
        head.setStroke(Color.BLACK);
        head.setFill(Color.WHITE);

        Circle[] pupil = {
                    new Circle(0, 0, 10),
                    new Circle(0, 0, 10),
                };
        for (Circle circle : pupil) {
            circle.setStroke(Color.BLACK);
            circle.setFill(Color.BLACK);
        }

        Ellipse[] eye = {
                new Ellipse(0, 0, 20, 15),
                new Ellipse(0, 0, 20, 15)
        };
        for (Ellipse ellipse : eye) {
            ellipse.setStroke(Color.BLACK);
            ellipse.setFill(Color.TRANSPARENT);
        }

        Arc mouth = new Arc(0, 0, 60, 60, 220, 100);
        mouth.setType(ArcType.OPEN);
        mouth.setStroke(Color.BLACK);
        mouth.setFill(Color.TRANSPARENT);

        double noseX1 = scene.getWidth()/2 - HEAD_RADIUS/5;
        double noseX2 = scene.getWidth()/2 + HEAD_RADIUS/5;
        Polygon nose = new Polygon(
       noseX1, scene.getHeight()/2 + HEAD_RADIUS/5,
                noseX2, scene.getHeight()/2 + HEAD_RADIUS/5,
                (noseX1 + noseX2)/2, scene.getHeight()/2 - HEAD_RADIUS/5
                );
        nose.setStroke(Color.BLACK);
        nose.setFill(Color.TRANSPARENT);

        primaryStage.show();

        head.centerXProperty().bind(pane.widthProperty().divide(2));
        head.centerYProperty().bind(pane.heightProperty().divide(2));

        pupil[0].centerXProperty().bind(head.centerXProperty().subtract(HEAD_RADIUS / 3));
        pupil[0].centerYProperty().bind(head.centerYProperty().subtract(HEAD_RADIUS / 3));
        pupil[1].centerXProperty().bind(head.centerXProperty().add(HEAD_RADIUS / 3));
        pupil[1].centerYProperty().bind(head.centerYProperty().subtract(HEAD_RADIUS / 3));

        eye[0].centerXProperty().bind(head.centerXProperty().subtract(HEAD_RADIUS / 3));
        eye[0].centerYProperty().bind(head.centerYProperty().subtract(HEAD_RADIUS / 3));
        eye[1].centerXProperty().bind(head.centerXProperty().add(HEAD_RADIUS / 3));
        eye[1].centerYProperty().bind(head.centerYProperty().subtract(HEAD_RADIUS / 3));

        mouth.centerXProperty().bind(pane.widthProperty().divide(2));
        mouth.centerYProperty().bind(pane.heightProperty().divide(2));

        pane.getChildren().addAll(head, pupil[0], pupil[1], eye[0], eye[1], mouth, nose);
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}

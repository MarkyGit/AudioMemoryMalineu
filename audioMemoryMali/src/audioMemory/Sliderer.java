package audioMemory; // 11.12.19 Bemerkung 4 Mark

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Sliderer extends Application {

	@Override
	public void start(Stage stage) {

		int sliderWert = 0;

		Label label = new Label("Lautstärke:");

		Label infoLabel = new Label("-");
		infoLabel.setTextFill(Color.BLUE);

		Slider slider = new Slider();

		slider.setMin(0);
		slider.setMax(100);
		slider.setValue(80);

		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);

		slider.setBlockIncrement(5);

		// Adding Listener to value property.
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, //
					Number oldValue, Number newValue) {

				infoLabel.setText("Lautstärke momentan: " + (int) slider.getValue());

			}

		});
		sliderWert = (int) slider.getValue();
		VBox root = new VBox();
		root.setPadding(new Insets(20));
		root.setSpacing(10);
		root.getChildren().addAll(label, slider, infoLabel);

		stage.setTitle("JavaFX Slider (o7planning.org)");
		Scene scene = new Scene(root, 350, 200);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {

		launch(args);

	}
}
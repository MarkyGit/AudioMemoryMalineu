package audioMemory;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI_main extends Application {

	private Stage primaryStage;
	private BorderPane mainLayout;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Sound Memory");
		showMainView();
		showButtons();
	}

	private void showMainView() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GUI_main.class.getResource("GUI.fxml"));
		try {
			mainLayout = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void showButtons() throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Buttons.fxml"));
		GridPane buttons = loader.load();
		mainLayout.setCenter(buttons);

	}

	public static void main(String[] args) {

		launch(args);

	}

}
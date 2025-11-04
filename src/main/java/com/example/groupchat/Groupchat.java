package com.example.groupchat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Groupchat extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        startServer();
        startClient(1);

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                javafx.application.Platform.runLater(() -> {
                    try {
                        startClient(2);
                        startClient(3);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        launch();
    }

    private void startServer() throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/groupchat/interfaces/ServerForm.fxml"));
        Stage stage=new Stage();
        stage.setTitle("Group Chat Server");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    private void startClient(int clientNumber) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/groupchat/interfaces/ClientForm.fxml"));
        Stage stage=new Stage();
        stage.setTitle("Group Chat Client "+clientNumber);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}

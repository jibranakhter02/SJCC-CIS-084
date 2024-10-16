/*
 * Name: Jibran Akhter - 1073973
 * Date: 5/7/2024
 * Project: JavaGUICellPhoneBill
 */

package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Dan McElroy
 */
public class JavaFXCellPhoneBill extends Application {
    // controls for the top pane
    Label lblTitle;
    // controls for the left pane
    Label lblPlansAndPrices;
    // controls for the center pane
    Label lblCustomerData;
    Label lblName;
    TextField txtName;
    TextField txtPlan;
    Label lblPlan;
    TextField txtGBused;
    Label lblGBused;
    // controls for the right pane 
    Label lblCustomerBill;
    Label lblCustomerName;
    Label lblPleasePay;
    // controls for the bottom pane
    Button btnCompute;
    Button btnClear;
    Button btnExit;

    final double PRICE_PER_GB = 15.00;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setTop(createTop());
        root.setLeft(createLeft());
        root.setCenter(createCenter());
        root.setRight(createRight());
        root.setBottom(createBottom());

        Scene scene = new Scene(root);
        primaryStage.setTitle("JavaFX Cell Phone Bill");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private HBox createTop() {
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        Font font36B = Font.font("Arial", FontWeight.BOLD, 36);
        lblTitle = new Label("Cell Phone Billing");
        lblTitle.setFont(font36B);
        hbox.getChildren().add(lblTitle);
        return hbox;
    }

    private VBox createLeft() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(0, 20, 0, 20));
        lblPlansAndPrices = new Label(
                "PLANS & PRICES\n" +
                "--------------------\n" +
                "A =  0 GB $50.00\n" +
                "B =  2 GB $60.00\n" +
                "C =  4 GB $70.00\n" +
                "D = 10 GB $90.00\n" +
                "+$15.00/GB over plan limit"
        );
        vbox.getChildren().add(lblPlansAndPrices);
        return vbox;
    }

    private VBox createCenter() {
        VBox vbox = new VBox();
        vbox.setSpacing(10.0);

        lblCustomerData = new Label("Customer Data");

        VBox vbox1 = new VBox();
        lblName = new Label("  Name");
        txtName = new TextField();
        txtName.setPrefSize(200, 20);
        vbox1.getChildren().addAll(lblName, txtName);

        HBox hbox2 = new HBox();
        txtPlan = new TextField();
        txtPlan.setPrefSize(40, 20);
        lblPlan = new Label("  Plan  (A-D)");
        hbox2.getChildren().addAll(txtPlan, lblPlan);

        HBox hbox3 = new HBox();
        txtGBused = new TextField();
        txtGBused.setPrefSize(40, 20);
        lblGBused = new Label("  GB Used");
        hbox3.getChildren().addAll(txtGBused, lblGBused);

        vbox.getChildren().addAll(lblCustomerData, vbox1, hbox2, hbox3);
        return vbox;
    }

    private VBox createRight() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(0, 20, 0, 20));
        vbox.setMinWidth(250);
        vbox.setSpacing(10.0);
        vbox.setAlignment(Pos.TOP_LEFT);

        lblCustomerBill = new Label("Customer Bill");
        lblCustomerName = new Label("Name: ");
        lblPleasePay = new Label("Please Pay:");
        vbox.getChildren().addAll(lblCustomerBill, lblCustomerName, lblPleasePay);
        return vbox;
    }

    private HBox createBottom() {
        HBox hbox = new HBox();
        hbox.setSpacing(20.0);
        hbox.setPrefHeight(50);
        hbox.setAlignment(Pos.CENTER);

        btnCompute = new Button("Compute");
        btnCompute.setPrefSize(110, 20);
        btnCompute.setOnAction(e -> compute());

        btnClear = new Button("Clear");
        btnClear.setPrefSize(110, 20);
        btnClear.setOnAction(e -> clear());

        btnExit = new Button("Exit");
        btnExit.setPrefSize(110, 20);
        btnExit.setOnAction(e -> System.exit(0));

        hbox.getChildren().addAll(btnCompute, btnClear, btnExit);
        return hbox;
    }

    private void compute() {
        try {
            String plan = txtPlan.getText().toUpperCase();
            int gbUsed = Integer.parseInt(txtGBused.getText());
            double totalCost = 0;
            int includedGB = 0;

            switch (plan) {
                case "A":
                    totalCost = 50.00;
                    includedGB = 0;
                    break;
                case "B":
                    totalCost = 60.00;
                    includedGB = 2;
                    break;
                case "C":
                    totalCost = 70.00;
                    includedGB = 4;
                    break;
                case "D":
                    totalCost = 90.00;
                    includedGB = 10;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid plan. Please enter A, B, C, or D.");
            }

            if (gbUsed > includedGB) {
                totalCost += (gbUsed - includedGB) * PRICE_PER_GB;
            }

            lblCustomerName.setText("Name: " + txtName.getText());
            lblPleasePay.setText("Please Pay: $" + String.format("%.2f", totalCost));
        } catch (NumberFormatException e) {
            lblCustomerName.setText("Error: Please enter a valid number for GB used.");
            lblPleasePay.setText("");
        } catch (IllegalArgumentException e) {
            lblCustomerName.setText(e.getMessage());
            lblPleasePay.setText("");
        }
    }

    private void clear() {
        txtName.setText("");
        txtPlan.setText("");
        txtGBused.setText("");
        lblCustomerName.setText("Name: ");
        lblPleasePay.setText("Please Pay:");
    }
}
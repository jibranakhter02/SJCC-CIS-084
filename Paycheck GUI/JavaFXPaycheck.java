package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.layout.Pane;
import javafx.scene.text.FontWeight;

public class JavaFXPaycheck extends Application {
    // Define constants
    public static final double OVERTIME_RATE = 1.5;
    public static final double TAX_RATE = 0.17;

    // UI Controls
    private static TextField txtHours, txtPayRate;
    private static TextArea txtPaycheck;

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        createControls(root);

        Scene scene = new Scene(root, 450, 320);
        stage.setTitle("JavaFX Paycheck Project");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static void btnComputeClick() {
        double hours;
        double payRate;
        double regHours, overtimeHours;
        double regPay, overtimePay;
        double grossPay, taxes, netPay;

        try {
            hours = Double.valueOf(txtHours.getText());
            payRate = Double.valueOf(txtPayRate.getText());
            if (hours < 0 || payRate < 0)
                throw new IllegalArgumentException("Inputs must be positive");
        } catch (NumberFormatException e) {
            txtPaycheck.setText("Values for hours and pay rate must be numeric");
            return;
        } catch (IllegalArgumentException e) {
            txtPaycheck.setText(e.getMessage());
            return;
        }

        if (hours <= 40) {
            regHours = hours;
            overtimeHours = 0.0;
        } else {
            regHours = 40.0;
            overtimeHours = hours - 40.0;
        }

        regPay = regHours * payRate;
        overtimePay = overtimeHours * payRate * OVERTIME_RATE;
        grossPay = regPay + overtimePay;
        taxes = grossPay * TAX_RATE;
        netPay = grossPay - taxes;

        txtPaycheck.setText(
            String.format("Your gross pay is $%.2f\n", grossPay) +
            String.format("Your taxes are    $%.2f\n", taxes) +
            String.format("Your net pay is   $%.2f", netPay));
    }

    private static void btnClearClick() {
        txtHours.clear();
        txtPayRate.clear();
        txtPaycheck.clear();
    }

    private static void createControls(Pane root) {
        Font font36B = Font.font("Ariel", FontWeight.BOLD, 36);
        Font font18  = Font.font("Ariel", FontWeight.NORMAL, 18);

        Label lblTitle = new Label("Dan's Paycheck Calculator");
        lblTitle.setFont(font36B);
        lblTitle.setLayoutX(12);
        lblTitle.setLayoutY(4);
        root.getChildren().add(lblTitle);

        Label lblHours = new Label("Hours");
        lblHours.setFont(font18);
        lblHours.setLayoutX(24);
        lblHours.setLayoutY(57);
        root.getChildren().add(lblHours);

        txtHours = new TextField();
        txtHours.setFont(font18);
        txtHours.setLayoutX(123);
        txtHours.setLayoutY(57);
        txtHours.setMaxSize(119,30);
        txtHours.setMinSize(119,30);
        root.getChildren().add(txtHours);

        Label lblPayRate = new Label("Pay Rate");
        lblPayRate.setFont(font18);
        lblPayRate.setLayoutX(24);
        lblPayRate.setLayoutY(101);
        root.getChildren().add(lblPayRate);

        txtPayRate = new TextField();
        txtPayRate.setFont(font18);
        txtPayRate.setLayoutX(123);
        txtPayRate.setLayoutY(95);
        txtPayRate.setMaxSize(119,30);
        txtPayRate.setMinSize(119,30);
        root.getChildren().add(txtPayRate);

        Button btnCompute = new Button("Compute");
        btnCompute.setFont(font18);
        btnCompute.setLayoutX(40);
        btnCompute.setLayoutY(148);
        btnCompute.setMaxSize(110,40);
        btnCompute.setMinSize(110,40);
        btnCompute.setOnAction(e -> btnComputeClick());
        root.getChildren().add(btnCompute);

        Button btnClear = new Button("Clear");
        btnClear.setFont(font18);
        btnClear.setLayoutX(160);
        btnClear.setLayoutY(148);
        btnClear.setMaxSize(110,40);
        btnClear.setMinSize(110,40);
        btnClear.setOnAction(e -> btnClearClick());
        root.getChildren().add(btnClear);

        Button btnExit = new Button("Exit");
        btnExit.setFont(font18);
        btnExit.setLayoutX(280);
        btnExit.setLayoutY(148);
        btnExit.setMaxSize(110,40);
        btnExit.setMinSize(110,40);
        btnExit.setOnAction(e -> System.exit(0));
        root.getChildren().add(btnExit);

        txtPaycheck = new TextArea();
        txtPaycheck.setFont(font18);
        txtPaycheck.setLayoutX(40);
        txtPaycheck.setLayoutY(205);
        txtPaycheck.setMinSize(400,100);
        txtPaycheck.setMaxSize(400,100);
        txtPaycheck.setEditable(false);
        root.getChildren().add(txtPaycheck);
    }
}
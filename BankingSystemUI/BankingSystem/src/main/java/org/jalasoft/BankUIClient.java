package org.jalasoft;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BankUIClient extends Application {

    private BankService bankServices;
    private int currentAccount;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initial configuration
        bankServices = new BankService();

        primaryStage.setTitle("Bank Application");

        // Create your components
        GridPane createAccountSection = buildCreateAccountSection();
        GridPane selectAccountSection = buildSelectAccountSection();
        GridPane depositSection = buildDepositsection();

        // Arrange your components
        GridPane root = createGridPaneCustomized();
        root.setPadding(new Insets(40, 80, 40, 80));

        root.add(createAccountSection, 0, 0);
        root.add(selectAccountSection, 2, 0);
        root.add(depositSection, 3, 0);

        // Final configuration
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private GridPane buildCreateAccountSection() {
        // define components
        Label selectOriginLabel = new Label("Select origin:  ");

        ComboBox<AccountOrigin> accontOriginComboBox = new ComboBox<>();
        accontOriginComboBox.getItems().addAll(AccountOrigin.values());
        accontOriginComboBox.getSelectionModel().selectFirst();

        Button createAccountButton = new Button("Create account");
        Label createAccountLabel = new Label("<Create account to see the account number>");

        // Define their behaviors
        createAccountButton.setOnAction(handler -> {
            AccountOrigin accountOrigin = accontOriginComboBox.getSelectionModel().getSelectedItem();

            int accountNumber = bankServices.newAccount(String.valueOf(accountOrigin));
            createAccountLabel.setText("The account created is: " + accountNumber);
        });

        // Arrange your components
        GridPane gridPane = createGridPaneCustomized();

        gridPane.add(selectOriginLabel, 0, 0);

        gridPane.add(accontOriginComboBox, 1, 0);

        gridPane.add(createAccountButton, 1, 1);

        gridPane.add(createAccountLabel, 1, 2);

        return gridPane;
    }

    private GridPane buildSelectAccountSection() {
        // define components
        Label accountNumberLabel = new Label("Account Number:  ");
        Label balanceLabel = new Label("Balance:  ");

        TextField accountNumberTextField = new TextField();
        TextField balanceTextField = new TextField();

        balanceTextField.setDisable(true);

        Button selectAccountButton = new Button("Select Account");

        // Define their behaviors
        selectAccountButton.setOnAction(handler -> {
            currentAccount = Integer.parseInt(accountNumberTextField.getText());

            int balance = bankServices.getBalance(currentAccount);
            balanceTextField.setText(String.valueOf(balance));
        });

        // Arrange your components
        GridPane gridPane = createGridPaneCustomized();

        gridPane.add(accountNumberLabel, 0, 0);

        gridPane.add(accountNumberTextField, 1, 0);

        gridPane.add(balanceLabel, 0, 1);

        gridPane.add(balanceTextField, 1, 1);
        gridPane.add(selectAccountButton, 1, 2);

        return gridPane;
    }

    private GridPane buildDepositsection() {
        // define components
        Label amountLabel = new Label("Amount :  ");
        Label balanceLabel = new Label("<The Balance after deposit>");

        TextField amountTextField= new TextField();

        Button depositButton = new Button("Deposit");

        // Define their behaviors
        depositButton.setOnAction(handler -> {
            int amount = Integer.parseInt(amountTextField.getText());
            bankServices.deposit(currentAccount,amount);

            int currentBalance =bankServices.getBalance(currentAccount);
            balanceLabel.setText("The new balance is: "+currentBalance);
        });

        // Arrange your components
        GridPane gridPane = createGridPaneCustomized();

        gridPane.add(amountLabel, 0, 0);

        gridPane.add(amountTextField, 1, 0);
        gridPane.add(depositButton, 1, 1);
        gridPane.add(balanceLabel, 1, 2);
       

        return gridPane;

    }

    private GridPane createGridPaneCustomized() {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        return gridPane;

    }

}
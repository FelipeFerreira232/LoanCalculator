import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoanCalculator extends Application{
    private Label anualInterestRate = new Label("Anual Interest Rate");
    private TextField inputAnualInterestRate = new TextField();
    private Label numberOfYears = new Label("Number of Years");
    private TextField inputNumberOfYears = new TextField();
    private Label loanAmount = new Label("Loan Amount");
    private TextField inputLoanAmount = new TextField();
    private Label monthlyPayment = new Label("Monthly Payment");
    private TextField inputMonthlyPayment = new TextField();
    private Label totalPayment = new Label("Total Payment");
    private TextField inputTotalPayment = new TextField();
    private Button buttonCalculate = new Button("Calculate");
    private GridPane pane = new GridPane();
        
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        pane.add(anualInterestRate, 0, 0);
        pane.add(inputAnualInterestRate, 1, 0);
        inputAnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);

        pane.add(numberOfYears, 0, 1);
        pane.add(inputNumberOfYears, 1, 1);
        inputNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);

        pane.add(loanAmount, 0, 2);
        pane.add(inputLoanAmount, 1, 2);
        inputLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);

        pane.add(monthlyPayment, 0, 3);
        pane.add(inputMonthlyPayment, 1, 3);
        inputMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);

        pane.add(totalPayment, 0, 4);
        pane.add(inputTotalPayment, 1, 4);
        inputTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);

        pane.add(buttonCalculate, 1, 5);
        buttonCalculate.setOnAction(e -> calculatePaymentInformation());
        
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(5);
        pane.setVgap(5);
        GridPane.setHalignment(buttonCalculate, HPos.RIGHT);
        Scene scene = new Scene(pane);

        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
        

    }


    private void calculatePaymentInformation() {
        double anualInterestRate = Double.parseDouble(inputAnualInterestRate.getText());
        int numberOfYears = Integer.parseInt(inputNumberOfYears.getText());
        double loanAmount = Double.parseDouble(inputLoanAmount.getText());

        Loan loan = new Loan(anualInterestRate, numberOfYears, loanAmount);

        inputMonthlyPayment.setText(String.format("$%.2f",loan.getMonthlyPayment()));
        inputTotalPayment.setText(String.format("$%.2f",loan.getTotalPayment()));
    }
}

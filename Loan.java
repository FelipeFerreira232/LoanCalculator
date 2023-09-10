import java.util.Date;

public class Loan {
    //Data fields
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;


    //Constructors
    public Loan(double newAnnualInterestRate, int newNumberOfYears, double newLoanAmount){
        this.annualInterestRate = newAnnualInterestRate;
        this.numberOfYears = newNumberOfYears;
        this.loanAmount = newLoanAmount;
        loanDate = new Date();
    }
    public Loan(){
        this(2.5, 1, 1000);
    }


    //Acessor and mutator methods
    public void setAnnualInterestRate(double newAnnualInterestRate){
        this.annualInterestRate = newAnnualInterestRate;
    }
    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }


    public void setNumberOfYears(int newNumberOfYears){
        this.numberOfYears = newNumberOfYears;
    }
    public int getNumberOfYears(){
        return this.numberOfYears;
    }

    
    public void setLoanAmount(double newLoanAmount){
        this.loanAmount = newLoanAmount;
    }
    public double getLoanAmount(){
        return this.loanAmount;
    }


    public Date getLoanDate(){
        //Caution: This method makes the class (and objects) mutable
        return this.loanDate;
    }


    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = 
            loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    

    @Override
    public String toString() {
        return "\n\n{" +
            " annualInterestRate='" + getAnnualInterestRate() + "'" +
            ", numberOfYears='" + getNumberOfYears() + "'" +
            ", loanAmount='" + getLoanAmount() + "'" +
            ", loanDate='" + getLoanDate().toString() + "'" +
            "}";
    }
}
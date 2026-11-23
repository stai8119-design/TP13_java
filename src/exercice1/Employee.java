package exercice1;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 10L;

    private final int code;             
    private final String nomcomplet;      
    private final double monthlyPay;     
    private transient String password;  

    public Employee(int code, String nomcomplet, double monthlyPay, String password) {
        this.code = code;
        this.nomcomplet = nomcomplet;
        this.monthlyPay = monthlyPay;
        this.password = password;
    }

    public int getCode() {
        return code;
    }

    public String getFullName() {
        return nomcomplet;
    }

    public double getMonthlyPay() {
        return monthlyPay;
    }

    public String getSecretKey() {
        return password;
    }

    @Override
    public String toString() {
        return String.format(
            "Employee[code=%d, nomcomplet=%s, monthlyPay=%.2f, password=%s]",code,nomcomplet,monthlyPay,(password == null ? "null" : password));
    }
}
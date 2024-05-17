package com.example.calculator;
public class Calculation {
    private int id;
    private String expression;
    private double result;

    public Calculation(int id, String expression, double result) {
        this.id = id;
        this.expression = expression;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public static boolean isExpressionComplete(String expression) {
        // Kiểm tra xem biểu thức có kết thúc bằng một toán tử hay không
        return !expression.matches(".*[+\\-*/]$");
    }
}

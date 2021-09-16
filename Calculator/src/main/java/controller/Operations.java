package controller;

public class Operations {

    final int SUM = 1;
    final int SUB = 2;
    final int DIV = 3;
    final int MUL = 4;

    public double doMath(int operation,double numberOne, double numberTwo) {
        return operation == SUM ? (numberOne + numberTwo) : operation == SUB ? (numberOne - numberTwo) : operation == DIV ? (numberOne / numberTwo) : operation == MUL ? (numberOne * numberTwo) : 0;
    }
}

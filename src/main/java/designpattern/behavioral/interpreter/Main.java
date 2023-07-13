package designpattern.behavioral.interpreter;

public class Main {
    public static void main(String[] args) {

        Expression isMale = ExpressionRepository.getMaleExpression();
        Expression isMarriedWoman = ExpressionRepository.getMarriedWomanExpression();

        System.out.println("John is Male? " + isMale.interpret("John"));
        System.out.println("Julie is a married woman? " + isMarriedWoman.interpret("Married Julie"));
    }
}

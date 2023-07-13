package designpattern.behavioral.interpreter.with.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        // Input from the user
        String questionAsked = "1 gallons to pints";

        ConversionContext conversionContext = new ConversionContext(questionAsked);

        double quantity = conversionContext.getQuantity();
        String fromUnit = conversionContext.getFromUnit();
        String toUnit = conversionContext.getToUnit();

        // Using Reflections API to find out the Class to implement
        try {
            // NOTE:-
            // A class (.java file) should be present with
            // the exact same name as the String value passed
            // to the method argument.
            Class tempClass = Class.forName("designpattern.behavioral.interpreter.with.reflections." + fromUnit);

            Constructor constructor = tempClass.getConstructor();

            // cast object to the abstract class
            Object convertFrom = (Expression) constructor.newInstance();

            // Find out the type of method parameters.
            Class[] methodParams = new Class[]{Double.TYPE};

            // Find out the method to be called
            // either toGallons, toPints, etc.
            Method conversionMethod = tempClass.getMethod(
                    toUnit,
                    methodParams);

            // find the value that we will be passing for each param
            Object[] params = new Object[]{quantity};

            //Call the required method using .invoke()
            String toQuantity = (String) conversionMethod.invoke(
                    convertFrom,
                    params);

            String answerToQues = conversionContext.getConversionResponse() + toQuantity + " " + toUnit;

            // Send response message to the UI
            System.out.println(answerToQues);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}

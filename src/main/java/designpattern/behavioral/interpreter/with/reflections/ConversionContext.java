package designpattern.behavioral.interpreter.with.reflections;

public class ConversionContext {

    private String conversionQuestion;
    private String conversionResponse;
    private String fromUnit;
    private String toUnit;

    private Double quantity;

    private String[] partsOfQuestion;

    public ConversionContext(String conversionQuestion) {
        this.conversionQuestion = conversionQuestion;

        // 1 Gallons to Pints
        partsOfQuestion = conversionQuestion.split(" ");

        // Applying Reflections API
        // It is important that the existing class name should match exactly
        fromUnit = partsOfQuestion[1].substring(0, 1).toUpperCase()
                + partsOfQuestion[1].substring(1).toLowerCase();

        // Applying Reflections API
        // It is important that the method names should match exactly
        toUnit = partsOfQuestion[3].toLowerCase();

        quantity = Double.valueOf(partsOfQuestion[0]);

        conversionResponse = partsOfQuestion[0] + " " + partsOfQuestion[1] + " equals ";
    }

    public String getConversionQuestion() {
        return conversionQuestion;
    }

    public String getConversionResponse() {
        return conversionResponse;
    }

    public String getFromUnit() {
        return fromUnit;
    }

    public String getToUnit() {
        return toUnit;
    }

    public Double getQuantity() {
        return quantity;
    }
}

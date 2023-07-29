package OOP.Task3;

public class TooLongTextAnalyzer implements TextAnalyzer {
    private final int maxLength;

    public int getMaxLength() {
        return maxLength;
    }

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        Label result = Label.OK;
        if (text.length() > getMaxLength()) {
            return Label.TOO_LONG;
        } else return result;
    }
}

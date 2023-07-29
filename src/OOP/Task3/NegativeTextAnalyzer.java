package OOP.Task3;

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private final String[] keywords = {":(", "=(", ":|"};
    private final Label label = Label.NEGATIVE_TEXT;

    public NegativeTextAnalyzer() {
    }

    @Override
    String[] getKeywords() {
        return keywords;
    }

    @Override
    Label getLabel() {
        return label;
    }
}

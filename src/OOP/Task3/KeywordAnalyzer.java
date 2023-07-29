package OOP.Task3;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    abstract String[] getKeywords();

    abstract Label getLabel();

    @Override
    public Label processText(String text) {
        return Label.OK;
    }

}

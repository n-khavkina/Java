package OOP.Task3;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    abstract String[] getKeywords();

    abstract Label getLabel();

    @Override
    public Label processText(String text) {
        Label result = Label.OK;
        for (String s : getKeywords()) {
            if (text.contains(s)) {
                return getLabel();
            }
        }
        return result;
    }

}

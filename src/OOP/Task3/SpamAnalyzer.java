package OOP.Task3;

public class SpamAnalyzer extends KeywordAnalyzer {
    private final String[] keywords;
    private final Label label = Label.SPAM;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    String[] getKeywords() {
        return keywords;
    }

    @Override
    Label getLabel() {
        return label;
    }

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

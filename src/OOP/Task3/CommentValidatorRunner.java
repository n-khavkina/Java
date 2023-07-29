package OOP.Task3;

public class CommentValidatorRunner {
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        Label result = Label.OK;
        for (TextAnalyzer t : analyzers) {
            if (result != Label.OK) break;
            result = t.processText(text);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers = {
                new NegativeTextAnalyzer(), new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)};
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong.";
        tests[2] = "Very negative comment !!!!=(!!!!;";
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";
        tests[4] = "This comment is so bad....";
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";
        tests[6] = "Negative bad :( spam.";
        tests[7] = "Very bad, very neg =(, very ..................";
        CommentValidatorRunner commentValidatorRunner = new CommentValidatorRunner();
        for (String test : tests) {
            System.out.println(commentValidatorRunner.checkLabels(textAnalyzers, test));
        }
    }
}


package json.t;

import java.util.List;
import java.util.Scanner;

public class ColourPicker {
    private static final String PREFIX = "\u001B[38;2;%d;%d;%dm";

    private static final String POSTFIX = "\u001B[0m";
    private List<Colour> colors;

    public void pick() {
        Scanner scanner = new Scanner(System.in);
        Colour colour;
        while (true) {
            showColours();
            System.out.print("id: ");
            try {
                String answer = scanner.next();
                colour = getColor(answer);
                break;
            } catch (Exception e) {
                System.out.println("Enter the correct colour id");
            }
        }

        if (colour != null) {
            System.out.println(
                    String.format(PREFIX, colour.getRed(), colour.getGreen(), colour.getBlue())
                            + "You favourite colour"
                            + POSTFIX
            );
        }


    }

    private Colour getColor(String answer) throws IndexOutOfBoundsException {
        if (this.colors.size() == 0) {
            return null;
        }
        for (Colour colour : this.colors) {
            if (colour.getId().equals(answer)) {
                return colour;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    private void showColours() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pick your favourite colour:\n");
        for (Colour colour : this.colors) {
            sb.append(String.format(PREFIX, colour.getRed(), colour.getGreen(), colour.getBlue()));
            sb.append(colour.getId()).append(" - ");
            sb.append(colour.getColor());
            sb.append(POSTFIX);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ColourPiker{");
        sb.append("colours=").append(colors);
        sb.append('}');
        return sb.toString();
    }

    public List<Colour> getColors() {
        return colors;
    }

    public void setColors(List<Colour> colors) {
        this.colors = colors;
    }
}

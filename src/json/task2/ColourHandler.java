package json.task2;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class ColourHandler {
    private static final String PREFIX = "\u001B[38;2;%d;%d;%dm";

    private static final String POSTFIX = "\u001B[0m";
    private List<Colour> colors;

    private java.awt.Color defineСolour(String value) {
        if (value.length() == 4) {
            char[] list = value.toCharArray();

            StringBuilder sb = new StringBuilder();
            sb.append(list[0]);
            for (int i = 1; i < list.length; i++) {
                for (int j = 0; j < 2; j++) {
                    sb.append(list[i]);
                }
            }
            value = sb.toString();
        }
        return Color.decode(value);
    }


    public void colorizeText() {
        Scanner scanner = new Scanner(System.in);
        showColours();
        System.out.print("Введите id: ");
        String answer = scanner.next();
        if (Integer.parseInt(answer) > 7) {
            System.out.println("id больше 7");
        }
        Colour colour = chooseColour(answer);
        if (colour != null) {
            System.out.println(String.format(PREFIX, defineСolour(colour.getValue()).getRed(),
                    defineСolour(colour.getValue()).getGreen(),
                    defineСolour(colour.getValue()).getBlue())
                    + "Твой любимый цвет"
                    + POSTFIX);
        }
    }

    public Colour chooseColour(String answer) {
        for (Colour color : this.colors) {
            if (color.getId().equals(answer)) {
                return color;
            }
        }
        return null;
    }

    private void showColours() {
        StringBuilder sb = new StringBuilder();
        sb.append("Выбери свой любимый цвет:\n");
        for (Colour color : this.colors) {
            Color rgb = defineСolour(color.getValue());
            sb.append(String.format(PREFIX, rgb.getRed(),
                    rgb.getGreen(),
                    rgb.getBlue()));
            sb.append(color.getId()).append(" - ");
            sb.append(color.getColor());
            sb.append(POSTFIX);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        return "ColourHandler{" +
                "colors=" + colors +
                '}';
    }

    public List<Colour> getColors() {
        return colors;
    }

    public void setColors(List<Colour> colors) {
        this.colors = colors;
    }
}

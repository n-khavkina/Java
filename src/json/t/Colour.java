package json.t;

public class Colour {
    private String id;
    private String color;
    private String value;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Colour{");
        sb.append("id='").append(id).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {

        if (value.matches("#\\w{3}")) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.substring(0, 1));
            sb.append(value.substring(1, 2)).append(value.substring(1, 2));
            sb.append(value.substring(2, 3)).append(value.substring(2, 3));
            sb.append(value.substring(3, 4)).append(value.substring(3, 4));
            value = sb.toString();
        }

        this.value = value;
    }

    public Integer getRed() {
        return Integer.valueOf(this.getValue().substring(1, 3), 16);
    }

    public Integer getGreen() {
        return Integer.valueOf(this.getValue().substring(3, 5), 16);
    }

    public Integer getBlue() {
        return Integer.valueOf(this.getValue().substring(5, 7), 16);
    }
}

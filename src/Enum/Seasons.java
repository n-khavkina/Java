package Enum;

public enum Seasons {
    SPRING, SUMMER, AUTUMN, WINTER;
    String description;
    int countOfDays;

    public static void printSeasons() {
        for (Seasons season : Seasons.values()) {
            System.out.println("Время года - " + season);
        }
    }

    public static Seasons getNextSeason(Seasons season) {
        if (season == Seasons.WINTER) {
            return Seasons.SPRING;
        } else {
            return Seasons.values()[season.ordinal() + 1];
        }
    }
}


package threads.task7;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
    private String name;
    private LocalDateTime date;
    private String descriprion;
    private Duration durationOfEvent = Duration.ofSeconds(5);
    private boolean isActive = false;

    public Event(String name, LocalDateTime date, String descriprion) {
        this.name = name;
        this.date = date;
        this.descriprion = descriprion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isActive() {
        return isActive;
    }

    public Duration getDurationOfEvent() {
        return durationOfEvent;
    }

    public void setDurationOfEvent(Duration durationOfEvent) {
        this.durationOfEvent = durationOfEvent;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", descriprion='" + descriprion + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}

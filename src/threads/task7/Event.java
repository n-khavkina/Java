package threads.task7;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Event {
    private String name;
    private LocalDateTime date;
    private String description;
    private boolean isActive = false;

    public Event(String name, LocalDateTime date, String description) {
        this.name = name;
        this.date = date;
        this.description = description;
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
        return description;
    }

    public void setDescriprion(String descriprion) {
        this.description = descriprion;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isActive() {
        return isActive;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return isActive == event.isActive && Objects.equals(name, event.name) && Objects.equals(date, event.date) && Objects.equals(description, event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, description, isActive);
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", descriprion='" + description + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}

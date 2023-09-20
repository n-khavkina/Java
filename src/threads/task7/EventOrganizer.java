package threads.task7;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class EventOrganizer implements Callable {
    private static Map<String, Event> map = new HashMap<>();
    Mode mode;
    Event event;
    LocalDateTime currentDate = LocalDateTime.now();
    public EventOrganizer(Mode mode, Event event) {
        this.mode = mode;
        this.event = event;
    }

    @Override
    public String call() throws Exception {
        switch (mode) {
            case MODE1:
                while (Duration.between(LocalDateTime.now(), event.getDate()).toHours() <= 1 &&
                        Duration.between(LocalDateTime.now(), event.getDate()).toSeconds() >= 0) {
                    long d = Duration.between(LocalDateTime.now(), event.getDate()).toSeconds();
                    System.out.println("Количество секунд до старта " + event.getName() + ": " + d);
                    Thread.sleep(1000);
                }
                break;
            case MODE2:
                while (!event.isActive()) {
                    TimeUnit.SECONDS.sleep(1);
                    compareDates(currentDate, event.getDate());
                }
                    System.out.println(event.getName() + " началось");
                break;
            case MODE3:
                while (!event.isActive()) {
                    TimeUnit.SECONDS.sleep(1);
                    compareDates(currentDate, event.getDate());
                }
                while (event.isActive()) {
                    System.out.println("Мероприятие уже началось! Не пропустите" + event.getName() + "!");
                    TimeUnit.MINUTES.sleep(1);
                }
        }
        return Thread.currentThread().getName();
    }

    public void compareDates(LocalDateTime currentDate, LocalDateTime dayOfEvent){
        if (currentDate.equals(dayOfEvent)) {
            event.setActive(true);
        }else {
            event.setActive(false);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Event event1 = new Event("Мероприятие1", LocalDateTime.now().plusSeconds(3), "aaa");
        Event event2 = new Event("Мероприятие2", LocalDateTime.
                of(2023, 9, 20, 17, 20), "aaa2");
        Event event3 = new Event("Мероприятие3", LocalDateTime.
                of(2023, 9, 20, 17, 10), "aaa3");
        map.put(event1.getName(), event1);
        map.put(event2.getName(), event2);
        map.put(event3.getName(), event3);

        Callable<String> eventOrganizer1 = new EventOrganizer(Mode.MODE1, event1);
        Callable<String> eventOrganizer2 = new EventOrganizer(Mode.MODE2, event1);
        Callable<String> eventOrganizer3 = new EventOrganizer(Mode.MODE3, event1);
        Future<String> future1 = pool.submit(eventOrganizer1);
        Future<String> future2 = pool.submit(eventOrganizer2);
        Future<String> future3 = pool.submit(eventOrganizer3);
        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
        pool.shutdown();

    }
}

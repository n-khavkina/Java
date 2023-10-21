package threads.task7;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class EventOrganizer implements Callable<String> {
    private Map<String, Event> map;
    Mode mode;

    public EventOrganizer(Mode mode, Map<String, Event> map) {
        this.mode = mode;
        this.map = map;
    }

    @Override
    public String call() throws Exception {
        while (true) {
            LocalDateTime now = LocalDateTime.now();
            for (Event event : map.values()) {
                Duration timeLeft = Duration.between(now, event.getDate());
                long secondsLeft = timeLeft.toSeconds();
                switch (mode) {
                    case MODE1:
                        if (secondsLeft < 60 && !event.isActive()) {
                            System.out.println("\n" + "Количество секунд до старта " + event.getName() + ": " +
                                    timeLeft.getSeconds());
                        }
                        break;
                    case MODE2:
                        if (secondsLeft == 0 && !event.isActive()) {
                            System.out.println(event.getName() + " началось");
                            event.setActive(true);
                        }
                        break;
                    case MODE3:
                        if (event.isActive() && timeLeft.toSeconds() >=-5) {
                            System.out.println("\n" + "Событие уже началось! Не пропустите " + event.getName() + "!");
                            break;
                        }
                }

            }
            Thread.sleep(1000);
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(6);
        Event event1 = new Event("Событие1", LocalDateTime.now().plusSeconds(10), "Описание1");
        Event event2 = new Event("Событие2", LocalDateTime.now().plusSeconds(5), "Описание2");
        Map<String, Event> map = new HashMap<>();

        map.put(event1.getName(), event1);
        map.put(event2.getName(), event2);

        Callable<String> eventOrganizer1 = new EventOrganizer(Mode.MODE1, map);
        Callable<String> eventOrganizer2 = new EventOrganizer(Mode.MODE2, map);
        Callable<String> eventOrganizer3 = new EventOrganizer(Mode.MODE3, map);

        Future<String> future1 = pool.submit(eventOrganizer1);
        Future<String> future2 = pool.submit(eventOrganizer2);
        Future<String> future3 = pool.submit(eventOrganizer3);

        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());

        pool.shutdown();
    }
}

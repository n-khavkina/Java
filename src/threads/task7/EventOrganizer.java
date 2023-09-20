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

    public EventOrganizer(Mode mode, Event event) {
        this.mode = mode;
        this.event = event;
    }

    @Override
    public String call() throws Exception {
        StringBuilder result = new StringBuilder("");
        switch (mode) {
            case MODE1:
                while (Duration.between(LocalDateTime.now(), event.getDate()).toHours() <= 1 &&
                        Duration.between(LocalDateTime.now(), event.getDate()).toSeconds() >= 0) {
                    long d = Duration.between(LocalDateTime.now(), event.getDate()).toSeconds();
                    result.append("\n" + "Количество секунд до старта " + event.getName() + ": " + d);
                    TimeUnit.SECONDS.sleep(1);
                    if (d == 0) {
                        event.setActive(true);
                    }
                }
                break;
            case MODE2:
                while (!event.isActive()) {
                    TimeUnit.SECONDS.sleep(1);
                }
                result.append(event.getName() + " началось");
                break;
            case MODE3:
                while (!event.isActive()) {
                    TimeUnit.SECONDS.sleep(1);
                }
                while (event.isActive()) {
                    if (LocalDateTime.now().isAfter(event.getDate().plus(event.getDurationOfEvent()))) {
                        result.append("\n" + "event.getName() + закончилось(");
                        break;
                    }
                    result.append("\n" + "Событие уже началось! Не пропустите " + event.getName() + "!");
                    TimeUnit.SECONDS.sleep(1);
                }
        }
        return Thread.currentThread().getName() + " " + result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(6);
        Event event1 = new Event("Событие1", LocalDateTime.now().plusSeconds(3), "Описание1");
        Event event2 = new Event("Событие2", LocalDateTime.now().plusSeconds(6), "Описание2");

        map.put(event1.getName(), event1);
        map.put(event2.getName(), event2);

        Callable<String> eventOrganizer1 = new EventOrganizer(Mode.MODE1, map.get("Событие1"));
        Callable<String> eventOrganizer2 = new EventOrganizer(Mode.MODE2, map.get("Событие1"));
        Callable<String> eventOrganizer3 = new EventOrganizer(Mode.MODE3, map.get("Событие1"));

        Callable<String> eventOrganizer4 = new EventOrganizer(Mode.MODE1, map.get("Событие2"));
        Callable<String> eventOrganizer5 = new EventOrganizer(Mode.MODE2, map.get("Событие2"));
        Callable<String> eventOrganizer6 = new EventOrganizer(Mode.MODE3, map.get("Событие2"));
        Future<String> future1 = pool.submit(eventOrganizer1);
        Future<String> future2 = pool.submit(eventOrganizer2);
        Future<String> future3 = pool.submit(eventOrganizer3);
        Future<String> future4 = pool.submit(eventOrganizer4);
        Future<String> future5 = pool.submit(eventOrganizer5);
        Future<String> future6 = pool.submit(eventOrganizer6);

        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());


        System.out.println(future4.get());
        System.out.println(future5.get());
        System.out.println(future6.get());
        pool.shutdown();

    }
}

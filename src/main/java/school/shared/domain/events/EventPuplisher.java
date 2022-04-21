package school.shared.domain.events;

import java.util.ArrayList;
import java.util.List;

public class EventPuplisher {

    private List<Listener> listeners = new ArrayList<>();

    public void add(Listener listener) {
        this.listeners.add(listener);
    }

    public void publish(Event event) {
        this.listeners.forEach(listener -> {
            listener.process(event);
        });
    }
}

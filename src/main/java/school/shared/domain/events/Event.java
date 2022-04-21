package school.shared.domain.events;

import java.time.LocalDateTime;
import java.util.Map;

public interface Event {

    LocalDateTime moment();

    EventType type();

    Map<String, Object> informations();
}

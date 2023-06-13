package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class TestCase {
    String description;
    String preconditions;
    String postconditions;
    String title;
    int severity;
    int priority;
    int behavior;
    int type;
    int layer;
    int is_flaky;
    int suite_id;
    int automation;
    int status;
}

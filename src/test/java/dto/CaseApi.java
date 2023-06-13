package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CaseApi {
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

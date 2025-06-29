package models.createDraft;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Permission {
    private int permitId;
    private String name;
    private String authority;
}

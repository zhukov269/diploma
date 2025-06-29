package models.createDraft;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Station {
    private int switchId;
    private String switchName;
    private int mrfId;
    private String mrfName;
}

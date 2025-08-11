package models.getSource;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor


public class saveSource {
    private String cprId;
    private Object operatorGroupId;
    private Object sourceOperators;
    private Object switchID;
    private Object trunkGroupID;
    private Object typeB;
    private Object typeId;

}

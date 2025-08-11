package models.getDst;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class saveDst {
    private String cities;
    private Integer cprId;
    private Integer defs;
    private String mrfs;
    private Integer prefixes;
    List<String> region  ;
    private String SourceOperators ;


}

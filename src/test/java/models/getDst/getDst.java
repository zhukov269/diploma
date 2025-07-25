package models.getDst;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor

public class getDst {
    private String cities;
    private Integer cprId;
    private Integer defs;
    private String mrfs;
    private Integer prefixes;
    List<String> region = new ArrayList<>() ;
    private String SourceOperators ;
    List<String> MRF = new ArrayList<>() ;

}

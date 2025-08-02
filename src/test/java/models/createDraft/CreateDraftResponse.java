package models.createDraft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class CreateDraftResponse {
    private String Id;
    private String createDateTime;
    private String releaseDateTime;
    private String priorityName;
    private String troubleTicket;
    private Integer statusId;
    private String changeDate;
    private String description;
    private String fromDate;
    private String toDate;
    private Integer typeId;
    private String controlDate;
    private Integer priorityId;
    private String statusName;
    private String createUser;
    private String typeName;
    private String createDateTimeFormatted;
    private String releaseDateTimeFormatted;
    private String fromDateFormatted;
    private String controlDateFormatted;


}

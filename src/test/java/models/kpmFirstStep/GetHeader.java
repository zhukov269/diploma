package models.kpmFirstStep;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetHeader {
    private int id;  // Будет подгружаться извне (например, через конструктор/сеттер)
    private String createDateTime;  // Можно заменить на LocalDate
    private String releaseDateTime;
    private String priorityName;
    private String troubleTicket;
    private Integer statusId;
    private String changeDate;
    private String description;
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

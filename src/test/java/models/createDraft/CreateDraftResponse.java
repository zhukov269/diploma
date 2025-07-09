package models.createDraft;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class CreateDraftResponse {
    private int id;
    private String lastName;
    private String firstName;
    private String thirdName;
    private String login;
    private String email;
    private String departament;
    private Mrf[] mrf;
    private Station[] stations;
    private Role[] roles;
    private String disabled;
    public String fromDate;
    public String toDate;
    private int undelivered;
    private Permission[] permissions;
}

package Entertainment.EMT.EMTShop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Setter
@Getter
public class PBForm {
    public String name;
    public Integer mobile;
    public String email;
    public String subject;
    public String info;

    public PBForm(String name,Integer mobile, String email, String subject, String info){
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.subject = email;
        this.info = info;
    }
}

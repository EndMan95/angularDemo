package angular.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Human {

    private Long humanId;
    private String name;
    private boolean sex;

    public Human(Long humanId, String name, boolean sex) {
        this.humanId = humanId;
        this.name = name;
        this.sex = sex;
    }
    
    public Human(HumanForm humanForm){
        this.humanId = humanForm.getHumanId();
        this.name = humanForm.getName();
        this.sex = humanForm.isSex();
    }
}

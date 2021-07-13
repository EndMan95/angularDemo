package angular.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HumanForm {

    private Long humanId;
    private String name;
    private boolean sex;
    
}

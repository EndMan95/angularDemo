package angular.demo.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import angular.demo.model.Human;
import angular.demo.model.HumanForm;

@Repository
public class HumanDao {

    private static final Map<Long, Human> humanMap = new HashMap<Long, Human>();

    static {
        initHumans();
    }

    private static void initHumans() {
        Human h1 = new Human(1L, "hieu", true);
        Human h2 = new Human(2L, "truong", false);
        Human h3 = new Human(3L, "thuong", false);

        humanMap.put(h1.getHumanId(), h1);
        humanMap.put(h2.getHumanId(), h2);
        humanMap.put(h3.getHumanId(), h3);

    }

    public Long getMaxHumanId() {
        Set<Long> keys = humanMap.keySet();
        Long max = 0L;
        for (Long key : keys) {
            if (key > max) {
                max = key;
            }
        }
        return max;
    }

    public Human getHuman(Long humanId) {
        return humanMap.get(humanId);
    }

    public Human addHuman(HumanForm humanForm) {
        Long humanId = this.getMaxHumanId() + 1;
        humanForm.setHumanId(humanId);
        Human newHuman = new Human(humanForm);
        humanMap.put(newHuman.getHumanId(), newHuman);
        return newHuman;
    }

    public Human updateHuman(HumanForm humanForm){
        Human human = this.getHuman(humanForm.getHumanId());
        if(human!=null){
            human.setName(humanForm.getName());
            human.setSex(humanForm.isSex());
        }
        return human;
    }

    public void deleteHuman(Long humanId){
        humanMap.remove(humanId);
    }

    public List<Human> getAllHumans(){
        Collection<Human> col = humanMap.values();
        List<Human> list = new ArrayList<Human>();
        list.addAll(col);
        return list;
    }
}

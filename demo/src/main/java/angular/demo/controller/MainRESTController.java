package angular.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import angular.demo.dao.HumanDao;
import angular.demo.model.Human;
import angular.demo.model.HumanForm;

@RestController
public class MainRESTController {
    
    @Autowired
    private HumanDao humanDao;

    @RequestMapping(value = "/humans", method = RequestMethod.GET, //
    produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Human> getAllHumans(){
        List<Human> list = humanDao.getAllHumans();
        return list;
    }

    @RequestMapping(value = "/human/{humanId}", method = RequestMethod.GET, //
    produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Human getHuman(@PathVariable("humanId") Long humanId){
        return humanDao.getHuman(humanId);
    }

    @RequestMapping(value = "/human", method = RequestMethod.POST, //
    produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Human addHuman(@RequestBody HumanForm humanForm){
        System.out.println("creating human " + humanForm.getName());
        return humanDao.addHuman(humanForm);
    }

    @RequestMapping(value = "/human", method = RequestMethod.PUT, //
    produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Human updateHuman(@RequestBody HumanForm humanForm){
        System.out.println("updating human id = " + humanForm.getHumanId());
        return humanDao.updateHuman(humanForm);
    }

    @RequestMapping(value = "/human/{humanId}", method = RequestMethod.DELETE, //
    produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteHuman(@PathVariable("humanId") Long humanId){
        System.out.println("deleting human id = " + humanId);
        humanDao.deleteHuman(humanId);
    }
}

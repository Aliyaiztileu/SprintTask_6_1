package kz.group119.SprintTask_6_1.SprintTask_6_1.controllers;

import kz.group119.SprintTask_6_1.SprintTask_6_1.entities.ApplicationRequest;
import kz.group119.SprintTask_6_1.SprintTask_6_1.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private  RequestRepository requestRepository;
    @GetMapping ("/")
    public String getHome (Model model){

        List <ApplicationRequest> requests = requestRepository.findAll();
        model.addAttribute("requests", requests);
        return "index";
    }
    @GetMapping ("/details/{id}")
    public String detailPage (@PathVariable (name = "id") Long id, Model model){
        ApplicationRequest request = requestRepository.findById(id).orElse(null);
        model.addAttribute("request", request);
        return "details";
    }
    @GetMapping ("/addRequest")
    public String addRequest (){
        return "addRequest";
    }
    @PostMapping ("/add_request")
    public String addRequest2 (ApplicationRequest request){
        request.setHandled(false);
        requestRepository.save(request);
        return "redirect:/";
    }
    @GetMapping ("/handledRequests")
    public String handledRequests (Model model){
        List <ApplicationRequest> requests = requestRepository.findAll();
        model.addAttribute("requests", requests);
        return "handledRequests";
    }
    @GetMapping ("/unhandledRequests")
    public  String unhandledRequests (Model model){
        List <ApplicationRequest> requests = requestRepository.findAllByHandled(false);
        model.addAttribute("requests", requests);
        return "unhandledRequests";
    }
    @PostMapping ("/process_request")
    public String processRequest (ApplicationRequest request){
        request.setHandled(true);
        requestRepository.save(request);
        return "redirect:/";
    }
    @PostMapping ("/delete_request/{id}")
    public String deleteRequest (@PathVariable (name = "id") Long id){
        requestRepository.deleteById(id);
        return "redirect:/";
    }

}

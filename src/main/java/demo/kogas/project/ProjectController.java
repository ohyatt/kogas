package demo.kogas.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    //프로젝트 리스트 불러오기
    @GetMapping
    public String getProjectList(Model model) {
        List<Project> projects = projectService.getProjectList();
        model.addAttribute("projects", projects);
        return "index";
    }

    //프로젝트 생성 폼
    @GetMapping("/create")
    public String formProject() {
        return "create";
    }

    //프로젝트 생성
    @PostMapping("/create")
    public ResponseEntity<Project> createProject(@RequestParam("title") String title, @RequestParam("name") String name) {
        return ResponseEntity.ok(projectService.createProject(title, name));  // Project 객체를 반환하여 id 포함
    }


//    @PostMapping("/create")
//    public ResponseEntity<Project> createProject(@RequestParam("title") String title, @RequestParam("name") String name) {
//        Project project = projectService.createProject(title, name);
//        System.out.println("Created project ID: " + project.getId());  // 로그로 ID 확인
//        return ResponseEntity.ok(project);
//    }


    @GetMapping("detail/{id}")
    public String formDetail() {
        return "project";
    }

//    //프로젝트 생성
//    @PostMapping("/taskCreation")
//    public ResponseEntity<Object> createProject(@RequestParam("taskType") Type type){
//        return ResponseEntity.ok(projectService.createProject(type));
//    }

}

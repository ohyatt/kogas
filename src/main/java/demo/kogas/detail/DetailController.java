package demo.kogas.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detail")
public class DetailController {

    @Autowired
    private final DetailService detailService;

    //프로젝트 세부사항 폼
    @GetMapping("/{id}")
    public String formDetail() {
        return "project";
    }

    //1. 업무 선택
    @PostMapping("/{id}")
    public ResponseEntity<String> selectTask(@PathVariable("id") Long id, @RequestParam("taskType") String taskType) {
        detailService.selectTask(id, taskType);
        return ResponseEntity.ok("Task selected successfully");
    }

}

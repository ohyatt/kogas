package demo.kogas.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/detail")
public class DetailController {

    @Autowired
    private DetailService detailService;

    //프로젝트 세부사항 폼
    @GetMapping("/{id}")
    public String formDetail() {
        return "project";
    }

    //1. 공사시행 품의 필요서류 업로드
    @PostMapping("/{id}")
    public ResponseEntity<String> saveProposal(@PathVariable Long id, @RequestBody DetailRequestDTO detailRequestDTO) {
        String phase = detailRequestDTO.getPhase();
        List<String> data = detailRequestDTO.getData();

        // phase에 따라 다른 서비스 메서드를 호출
        if ("proposal".equals(phase)) {
            return ResponseEntity.ok(detailService.saveProposal(id,data));
        } else if ("contractRequest".equals(phase)) {
            return ResponseEntity.ok(detailService.saveRequest(id,data));
        } else {
            return ResponseEntity.badRequest().body("Invalid type");
        }
    }

}

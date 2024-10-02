package demo.kogas.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService {

    @Autowired
    private DetailRepository detailRepository;

    public String saveProposal(Long id, List<String> filePaths){
        // filePaths를 사용하여 파일 경로 처리
        for (String filePath : filePaths) {
            System.out.println("Uploaded file path: " + filePath);
        }
    }


}

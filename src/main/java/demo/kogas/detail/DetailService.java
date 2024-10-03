package demo.kogas.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService {

    @Autowired
    private DetailRepository detailRepository;

    public String saveProposal(Long id, List<String> proposal){
        Detail detail = detailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detail not found"));

        detail.setProposal(proposal);

        detailRepository.save(detail);
        return "Success";
    }

    public String saveRequest(Long id, List<String> request){
        Detail detail = detailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detail not found"));

        detail.setRequest(request);

        detailRepository.save(detail);
        return "Success";
    }


}

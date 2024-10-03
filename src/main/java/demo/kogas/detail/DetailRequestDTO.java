package demo.kogas.detail;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DetailRequestDTO {
    private String phase;
    private List<String> data;
}

package demo.kogas.project;

import demo.kogas.detail.Detail;
import demo.kogas.detail.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DetailRepository detailRepository;
    public List<Project> getProjectList() {
        return projectRepository.findAll();
    }

    public Project createProject(String title, String name, Type type, String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        Project project = new Project(title, name, type, start, end);
        Detail detail = new Detail();
        detail.setProject(project);
        projectRepository.save(project);
        detailRepository.save(detail);
        System.out.println("Created project ID: " + project.getId());
        return project;  // 프로젝트 객체를 반환하여 id 포함
    }
}

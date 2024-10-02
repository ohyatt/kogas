package demo.kogas.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getProjectList() {
        return projectRepository.findAll();
    }

    public Project createProject(String title, String name) {
        Project project = new Project(title, name);
        projectRepository.save(project);
        System.out.println("Created project ID: " + project.getId());
        return project;  // 프로젝트 객체를 반환하여 id 포함
    }
}

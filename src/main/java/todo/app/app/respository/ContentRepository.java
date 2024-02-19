package todo.app.app.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import todo.app.app.models.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, String>{

    Content findOneById(String id);
}

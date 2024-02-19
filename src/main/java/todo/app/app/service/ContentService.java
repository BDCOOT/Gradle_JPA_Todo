package todo.app.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import todo.app.app.models.Content;
import todo.app.app.respository.ContentRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;

    @Transactional
    public void createContent(Content content) throws Exception{
        try{
           contentRepository.save(content);
        }catch(Exception e){
            throw new Exception(e);
        }
    }

    public List<Content> getToDoList() throws Exception {
        try{
            return contentRepository.findAll();
        }catch(Exception e){
            throw new Exception(e);
        }
    }

    public Content findById(String id) throws Exception{
        try{
            return contentRepository.findOneById(id);
        }catch(Exception e){
            throw new Exception(e);
        }
    }

    @Transactional
    public void deleteContent(String id) throws Exception{
        try{
            contentRepository.deleteById(id);
        }catch(Exception e){
            throw new Exception(e);
        }
    }
    




}//class 끝

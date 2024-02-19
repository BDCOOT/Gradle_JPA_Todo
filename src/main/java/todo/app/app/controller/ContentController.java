package todo.app.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.app.app.models.Content;
import todo.app.app.service.ContentService;
import todo.app.app.utils.GenerateId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/todo")
public class ContentController {

    private final ContentService contentService;
    private final GenerateId generateId;

    @GetMapping("/hello")
    public ResponseEntity<Object> hello() throws Exception {
        try{
            Map<String, String> map = new HashMap<>();
            map.put("result", "hello");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> map = new HashMap<>();
            map.put("error", e.toString());
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    @PostMapping("/create/content")
    public ResponseEntity<Object> createContent(@RequestBody Content req) throws Exception{
        try{
            Map<String, String> map = new HashMap<>();

            String shortUUID = generateId.shortUUID();
            req.setId(shortUUID);

            contentService.createContent(req);

            map.put("result", "컨텐트 작성 성공");
            return new ResponseEntity<>(map, HttpStatus.OK);

        }catch(Exception e){
            Map<String, String> map = new HashMap<>();
            map.put("error", e.toString());
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    @GetMapping("/gettodolist")
    public ResponseEntity<Object> getToDoList()throws Exception{
        try{
            Map<String, Object> map = new HashMap<>();

            List<Content> ContentList = contentService.getToDoList();

            map.put("result", ContentList);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }catch(Exception e){
            Map<String, String> map = new HashMap<>();
            map.put("error", e.toString());
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    @PostMapping("/modify/content")
    public ResponseEntity<Object> modifyContent(@RequestBody Content req) throws Exception{
        try{
            Map<String, String> map = new HashMap<>();

            Content content = contentService.findById(req.getId());
            content.setContent(req.getContent());

            contentService.createContent(content);

            map.put("result", "내용 수정 성공");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }catch(Exception e){
            Map<String, String> map = new HashMap<>();
            map.put("error", e.toString());
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> deleteContent(@RequestBody Content req) throws Exception{
        try{
            Map<String, String> map = new HashMap<>();

            contentService.deleteContent(req.getId());

            map.put("result", "컨텐트 삭제 성공");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }catch(Exception e){
            Map<String, String> map = new HashMap<>();
            map.put("error", e.toString());
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

}//class 끝

package pl.piotrludynia.eventMenager.comments;


import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment>listOfComments(){
        return commentRepository.findAll();
    }
    boolean created(String author, String content){
        Comment comment = new Comment(author,content);
        Comment created = commentRepository.save(comment);
        return created.getId() != null;
    }
}

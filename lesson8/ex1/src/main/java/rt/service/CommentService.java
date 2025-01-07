package rt.service;

import org.springframework.stereotype.Service;
import rt.aspect.ToLog;
import rt.model.Comment;

import java.util.logging.Logger;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @ToLog
    public String publishComment(Comment comment) {
        System.out.println("new comment from " + comment.getAuthor() + ": " + comment.getText());
        return "ok";
    }

    public void whoisAuthor(Comment comment){
        System.out.println(comment.getAuthor());
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}

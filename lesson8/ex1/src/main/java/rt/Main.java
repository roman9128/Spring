package rt;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rt.config.Config;
import rt.model.Comment;
import rt.service.CommentService;

public class Main {
    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(Config.class);
        var service = c.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setAuthor("Leo");
        comment.setText("naaa");

        service.publishComment(comment);
    }
}
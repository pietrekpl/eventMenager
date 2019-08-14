package pl.piotrludynia.eventMenager.comments;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "/showDetails/{id}/comment", method = RequestMethod.GET)
    public String createComment(@PathVariable long id, @ModelAttribute("comment")Comment comment){
        return "commentForm";
    }
    @RequestMapping(value = "/showDetails/{id}/comment/show", method = RequestMethod.POST)
    public String showComments(@PathVariable long id, @ModelAttribute("comment")Comment comment,
                               BindingResult result,Model model){
        try {
            boolean score = commentService.created(comment.getAuthor(),comment.getContent());
            model.addAttribute("commentCreated",score);

        }catch (Exception e){
            e.getMessage();
        }
        if (result.hasErrors()){
            return "commentForm";
        }else{
            return "commentConfirm";
        }
    }
    @RequestMapping(value = "/showDetails/{id}/comment/showCommentList", method = RequestMethod.GET)
    public String showCommentsList(@PathVariable long id,Model model){
        List<Comment>listOfComments = commentService.listOfComments();
        model.addAttribute("listOfComments",listOfComments);
        return "commentList";
    }
}

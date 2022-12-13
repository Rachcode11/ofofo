package data.repositories;

import data.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository{
    private final List<Comment> commentDb = new ArrayList<>();
    int count;
    @Override
    public Comment save(Comment comment) {
        if (comment.getId() != 0)updateComment(comment);
        else {
            comment.setId(++count);
            commentDb.add(comment);
        }
        return comment;
    }

    private void updateComment(Comment comment) {
        Comment previousComment = findById(comment.getId());
        previousComment.setComment(comment.getComment());
        previousComment.setCommenterName(comment.getCommenterName());

    }

    @Override
    public Comment findById(int id) {
        for (Comment comment:commentDb) if (comment.getId() == id)return comment;
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return commentDb;
    }

    @Override
    public long count() {
        return commentDb.size();
    }

    @Override
    public void delete(Comment comment) {
        commentDb.remove(comment);

    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < commentDb.size(); i++){
           Comment comment = commentDb.get(i);
           if (comment.getId() == id){
               commentDb.remove(comment);
               break;
           }
        }

    }
}

package ru.netology.mapper;

import org.springframework.stereotype.Component;
import ru.netology.model.Post;
import ru.netology.model.PostTDO;


@Component
public class Mapper {
    public PostTDO toPostTDO(Post post) {
        return new PostTDO(post.getId(), post.getContent());
    }

    public Post toPost(PostTDO postTDO) {
        return new Post(postTDO.getId(), postTDO.getContent());
    }
}

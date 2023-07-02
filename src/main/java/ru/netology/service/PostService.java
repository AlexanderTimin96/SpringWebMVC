package ru.netology.service;

import org.springframework.stereotype.Service;
import ru.netology.exception.NotFoundException;
import ru.netology.mapper.Mapper;
import ru.netology.model.Post;
import ru.netology.model.PostTDO;
import ru.netology.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;
    private final Mapper mapper;

    public PostService(PostRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<PostTDO> all() {
        List<Post> listPost = repository.all();
        List<PostTDO> listPostTDO = new ArrayList<>();
        for (Post post : listPost) {
            if (!post.isRemoved()) {
                listPostTDO.add(mapper.toPostTDO(post));
            }
        }
        return listPostTDO;
    }

    public PostTDO getById(long id) {
        Post post = repository.getById(id).orElseThrow(NotFoundException::new);
        if (post.isRemoved()) {
            throw new NotFoundException();
        }
        return mapper.toPostTDO(post);
    }

    public PostTDO save(PostTDO postTDO) {
        Post post = mapper.toPost(postTDO);
        Post postFromRepo = repository.save(post);
        return mapper.toPostTDO(postFromRepo);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}

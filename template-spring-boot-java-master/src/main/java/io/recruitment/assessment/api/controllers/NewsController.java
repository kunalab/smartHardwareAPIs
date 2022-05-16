package io.recruitment.assessment.api.controllers;

import io.recruitment.assessment.api.Repo.NewsRepo;

import io.recruitment.assessment.api.model.News;

import io.recruitment.assessment.api.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/News")
public class NewsController {
    @Autowired
    NewsRepo repo;
    @GetMapping(path = "/getNews")
    public List<News> getNews() {

        return repo.findAll();
    }
    @PostMapping(path="/addNews",consumes= {"application/json"})
    public News addProduct(@RequestBody News news)
    {
        repo.save(news);
        return news;
    }
    @DeleteMapping(path="/deleteNews/{news_id}")
    public String deleteProduct(@PathVariable int news_id)
    {
        News n = repo.getOne(news_id);
        repo.deleteById(news_id);
        return "Deleted Successfully";
    }
}

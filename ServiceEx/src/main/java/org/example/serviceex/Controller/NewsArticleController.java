package org.example.serviceex.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.serviceex.ApiResponse.ApiResponse;
import org.example.serviceex.Model.NewsArticle;
import org.example.serviceex.Service.NewsArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/NewsArticle-system")
@RequiredArgsConstructor
public class NewsArticleController {


    private final NewsArticleService newsArticleS;


    @GetMapping("/get")
    public ResponseEntity getNewsArticle(){

        ArrayList<NewsArticle> newsArticles = newsArticleS.getNewsArticles();

        return ResponseEntity.status(200).body(newsArticles);
    }


    @PostMapping("/add")
    public ResponseEntity addNewsArticle(@RequestBody @Valid NewsArticle newsArticle, Errors errors){

        if(errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        newsArticleS.addArticles(newsArticle);

        return ResponseEntity.status(200).body(new ApiResponse("Article added successfully!"));

    }

    @PutMapping("/update/{ID}")
    public ResponseEntity updateArticle(@PathVariable String ID, @RequestBody @Valid NewsArticle newsArticle, Errors errors){

        if(errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        boolean isUpdated = newsArticleS.updateArticle(ID, newsArticle);

        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Article updated successfully!"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Article's ID not found!"));

    }

    @DeleteMapping("/delete/{ID}")
    public ResponseEntity deleteArticle(@PathVariable String ID){

        boolean isDeleted = newsArticleS.deleteArticle(ID);

        if(isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("This article deleted successfully!"));
        }

        return ResponseEntity.status(400).body("Article's ID not found!");

    }

    @PutMapping("/publish/{ID}")
    public ResponseEntity publishArticles(@PathVariable String ID) {

        boolean isPublished = newsArticleS.publishArticles(ID);

        if (isPublished) {

            return ResponseEntity.status(200).body(new ApiResponse("This article published successfully!"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("This article's ID not found!"));

    }


    @GetMapping("/published-articles")
    public ResponseEntity allPublished(){


        ArrayList<NewsArticle> publishedArticles = newsArticleS.allPublished();

        return ResponseEntity.status(200).body(publishedArticles);

    }

    @GetMapping("/searchByCat/{category}")
    public ResponseEntity getByCategory(@PathVariable String category){

        ArrayList<NewsArticle> articlesBasedCategory = newsArticleS.getByCategory(category);

        if(articlesBasedCategory.isEmpty()){
            return ResponseEntity.status(400).body(new ApiResponse("Not found!"));
        }


        return ResponseEntity.status(200).body(articlesBasedCategory);


    }




} //End controller

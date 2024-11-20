package org.example.serviceex.Service;


import org.example.serviceex.Model.NewsArticle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service

public class NewsArticleService {


    ArrayList<NewsArticle> newsArticlesArr = new ArrayList<>();

    public ArrayList<NewsArticle> getNewsArticles(){

        return newsArticlesArr;
    }
    //////////////////////

    public void addArticles(NewsArticle newsArticle){

         newsArticlesArr.add(newsArticle);

    }


    ///////////////////////

    public boolean updateArticle(String ID, NewsArticle newsArticle){

        for (int i = 0; i < newsArticlesArr.size(); i++) {

            if(newsArticlesArr.get(i).getID().equals(ID)){
                newsArticlesArr.set(i, newsArticle);
                return true;
            }

        } //End for

        return false;
    }

    ////////////////////

    public boolean deleteArticle(String ID){

        for(NewsArticle n : newsArticlesArr){
            if(n.getID().equals(ID)){
                newsArticlesArr.remove(n);
                return true;
            }
        }

        return false;

    }

    //////////////////////////

    public boolean publishArticles(String ID){


       for(NewsArticle n : newsArticlesArr) {
           if(!n.isPublished() && n.getID().equals(ID)) {
               n.setPublished(true);
               return true;
           }
       }
        return false;
    }


    public ArrayList<NewsArticle> allPublished(){

        ArrayList<NewsArticle> allPublishedArticles = new ArrayList<>();
        for(NewsArticle n : newsArticlesArr){
            if(n.isPublished()){
                allPublishedArticles.add(n);
            }
        }
        return allPublishedArticles;

    }

    public ArrayList<NewsArticle> getByCategory(String category){

        ArrayList<NewsArticle> articlesBasedCategory = new ArrayList<>();


        for(NewsArticle n : newsArticlesArr){
            if(n.getCategory().equalsIgnoreCase(category)){
                articlesBasedCategory.add(n);

            }
        } //End for
        return articlesBasedCategory;


    }

















} //End service

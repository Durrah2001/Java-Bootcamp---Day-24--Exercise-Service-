package org.example.serviceex.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
public class NewsArticle {

    @NotEmpty(message = "ID can't be empty!")
    private String ID;

    @NotEmpty(message = "Title can't be empty!")
    @Size(max= 100, message = "Maximum number of character in title can't be more than 100!")
    private String title;

    @NotEmpty(message = "Author can't be empty!")
    @Size(min= 5, max= 20 , message = "Author name must be more than 4, and less than 20 letters!")
    private String author;

    @NotEmpty(message = "Content can't be empty!")
    @Size(min= 300, message = "Content must be more than 200 characters!")
    private String content;

    @NotEmpty(message = "Category can't be empty!")
    @Pattern(regexp = "^(politics|sports|technology)$", message = "Category must be either \"politics\", \"sports\", or \"technology\" only!")
    private String category;


    @NotEmpty(message = "Image URL can't be empty!")
    private String imageURL;

    @AssertFalse(message = "Default value is false.")
    private boolean isPublished;

    @JsonFormat
    private Date publishDate;


//    Artificial intelligence and machine learning are
//    transforming industries by automating processes,
//    enhancing decision-making, and enabling personalized experiences.
//    They drive advancements in robotics, healthcare, and cybersecurity.






}

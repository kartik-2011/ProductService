package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
//    @Id
//    private long id;--> Moved to the BaseModel class.
    private String title;
    private double price;
    private String description;
    private String image;
    @ManyToOne
    private Category category;

    /* for category we have to define the cardinality
            1    -->     1
        Product ---- Category =====>  M : 1
            M    <--     1
    ------------------------------
            M            1

      Example-:
            1    -->     M
         Movie ------> Actor ======>  M : M
            M     <--    1
    -------------------------------
            M           M
     */
}

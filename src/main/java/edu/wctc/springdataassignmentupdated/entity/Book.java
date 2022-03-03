package edu.wctc.springdataassignmentupdated.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@Table(name="Book")
public class Book {
    @Id
    @Column(name="book_id")
    private int id;
    @Column(name="price")
    private int price;
    @Column(name="title")
    private String title;
    @Column(name="inventory")
    private int inventory;
    @Column(name="image_file_name")
    private String imageFileName;
    @Min(1)
    @Max(10)
    @Column(name="sell")
    private int sell;
}

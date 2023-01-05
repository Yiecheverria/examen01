package com.distribuida.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books implements Serializable {
    private Integer id;
    private String isbn;
    private String title;
    private String author;
    private Double price;
}

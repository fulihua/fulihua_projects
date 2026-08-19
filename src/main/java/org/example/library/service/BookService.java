package org.example.library.service;

import org.example.library.entity.Book;
import org.example.library.exception.BookNotFoundException;
import org.example.library.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author fulihua
 * @date 2026/8/7 5:07 PM
 * @description
 */

@Component
public class BookService {
    @Autowired
    private BookMapper bookmapper;
    public List<Book> getAllBooks(){
        return bookmapper.getAll();
    }
    public int addBooks(Book book){
        return bookmapper.addBooks(book);
    }
    public Book getBooksById(int id){

         Book tempbook = bookmapper.getBooksById(id);
         if(tempbook == null){
             throw new BookNotFoundException("图书不存在+ID:"+id);
         }
         else {return tempbook;}
    }
    public int updateBooks(Book book){
        return bookmapper.updateBooks(book);
    }
    public int deleteBooks(int id){return bookmapper.deleteBooks(id);}
}
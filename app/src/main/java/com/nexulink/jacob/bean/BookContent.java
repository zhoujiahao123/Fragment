package com.nexulink.jacob.bean;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS-NB on 2016/12/14.
 */

public class BookContent {
    public static final String TAG = "LOG_FLAG";
    public static class Book{
        public  int id;
        public String titles;
        public String content;

        public Book(int id,String titles,String content){
            this.id= id;
            this.titles = titles;
            this.content = content;
        }
        public String toString(){
            return titles;
        }
    }
         public static List<Book> ITEMS = new ArrayList<Book>();
         public static Map<Integer,Book> ITEMS_MAP = new HashMap<Integer, Book>();
    static{
        Log.e(TAG,"BookContent静态代码块执行了");
        addItem(new Book(1,"安卓开发艺术探索","一本我假期准备修读的关于安卓开始的书籍。"));
        addItem(new Book(2,"Thinking in java","java书籍中的圣经"));
        addItem(new Book(3,"编译原理","所有必修读的书籍之一"));
    }
    public static void addItem(Book book){
        ITEMS.add(book);
        ITEMS_MAP.put(book.id,book);
    }
}

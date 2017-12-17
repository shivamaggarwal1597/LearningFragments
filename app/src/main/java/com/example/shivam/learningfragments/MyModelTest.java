package com.example.shivam.learningfragments;

import com.example.shivam.learningfragments.dummy.CategoryContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shivam on 28/11/17.
 */

public class MyModelTest {
    public String name;
    public long id;
    public Map<String,List<CategoryContent.CategoryItem>> mp = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<String, List<CategoryContent.CategoryItem>> getMp() {
        return mp;
    }

    public void setMp(String a, List<CategoryContent.CategoryItem> l) {
        Map<String,List<CategoryContent.CategoryItem>> mp_demo = new HashMap<>();
        mp_demo.put(a,l);
        this.mp = mp_demo;
    }

    public MyModelTest(String name, long id) {
        this.name = name;
        this.id = id;

    }
}

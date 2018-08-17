package com.oceanize.animationapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    public  static List<Item> getData()
    {
       // List<Item> itemList= Arrays.asList("","")
        List<Item> itemList= new ArrayList<>();
        itemList.add(new Item("A","A" ));
        itemList.add(new Item("B","A" ));
        itemList.add(new Item("C","A" ));
        itemList.add(new Item("D","A" ));
        itemList.add(new Item("E","A" ));
        itemList.add(new Item("A","A" ));
        itemList.add(new Item("B","A" ));
        itemList.add(new Item("C","A" ));
        itemList.add(new Item("D","A" ));
        itemList.add(new Item("E","A" ));
        itemList.add(new Item("A","A" ));
        itemList.add(new Item("B","A" ));
        itemList.add(new Item("C","A" ));
        itemList.add(new Item("D","A" ));
        itemList.add(new Item("E","A" ));
        return itemList;
    }
}

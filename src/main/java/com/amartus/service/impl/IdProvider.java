package com.amartus.service.impl;

/**
 * Created by khe on 2017-02-21.
 */
public class IdProvider {
    static private int id = 0;
    static public int getId() {
        return id++; //post increment since we want to get first available id and set new available after(!)
    }
}

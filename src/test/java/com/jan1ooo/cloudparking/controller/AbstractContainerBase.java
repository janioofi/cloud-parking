package com.jan1ooo.cloudparking.controller;


import org.testcontainers.containers.MySQLContainer;

public abstract class AbstractContainerBase {
    static final MySQLContainer MY_SQL_CONTAINER;

    static {
        MY_SQL_CONTAINER = new MySQLContainer("mysql:8.0.27");
        MY_SQL_CONTAINER.start();
    }
}

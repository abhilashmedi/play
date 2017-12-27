/*
 * Copyright (C) 2009-2017 Lightbend Inc. <https://www.lightbend.com>
 */
package controllers;

import javax.inject.*;
import javax.inject.*;

import models.Book;
import play.Logger;
import play.db.*;
import io.ebean.*;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@Singleton
class JavaApplicationDatabase {

    private Database db;
    private final EbeanServer ebeanServer;
    private DatabaseExecutionContext executionContext;

    @Inject
    public JavaApplicationDatabase(Database db,EbeanConfig ebeanConfig, DatabaseExecutionContext executionContext) {
        this.db = db;
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }

    public CompletionStage<PagedList<Book>>  updateSomething() {
        Logger.info("A log message2");
        return supplyAsync(() ->
                ebeanServer.find(Book.class)
                        .setMaxRows(5)
                        .findPagedList(), executionContext);
    }
}
package com.goldmoon.domain.localsearchhistory;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocalSearchHistory is a Querydsl query type for LocalSearchHistory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLocalSearchHistory extends EntityPathBase<LocalSearchHistory> {

    private static final long serialVersionUID = -971112956L;

    public static final QLocalSearchHistory localSearchHistory = new QLocalSearchHistory("localSearchHistory");

    public final NumberPath<Long> count = createNumber("count", Long.class);

    public final DateTimePath<java.time.ZonedDateTime> createdAt = createDateTime("createdAt", java.time.ZonedDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath keyword = createString("keyword");

    public final DateTimePath<java.time.ZonedDateTime> updatedAt = createDateTime("updatedAt", java.time.ZonedDateTime.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QLocalSearchHistory(String variable) {
        super(LocalSearchHistory.class, forVariable(variable));
    }

    public QLocalSearchHistory(Path<? extends LocalSearchHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocalSearchHistory(PathMetadata metadata) {
        super(LocalSearchHistory.class, metadata);
    }

}


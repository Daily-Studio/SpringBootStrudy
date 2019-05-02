package org.dailystudio.springbootstudy.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClerk is a Querydsl query type for Clerk
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClerk extends EntityPathBase<Clerk> {

    private static final long serialVersionUID = 835935096L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClerk clerk = new QClerk("clerk");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QStore store;

    public QClerk(String variable) {
        this(Clerk.class, forVariable(variable), INITS);
    }

    public QClerk(Path<? extends Clerk> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QClerk(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QClerk(PathMetadata metadata, PathInits inits) {
        this(Clerk.class, metadata, inits);
    }

    public QClerk(Class<? extends Clerk> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store")) : null;
    }

}


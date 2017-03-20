package me.gomko.api.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QManual is a Querydsl query type for Manual
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QManual extends EntityPathBase<Manual> {

    private static final long serialVersionUID = -1203983583L;

    public static final QManual manual = new QManual("manual");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<org.joda.time.DateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<org.joda.time.DateTime> lastModifiedDate = _super.lastModifiedDate;

    public final EnumPath<me.gomko.api.util.ManualType> manualType = createEnum("manualType", me.gomko.api.util.ManualType.class);

    public final StringPath message = createString("message");

    public final StringPath title = createString("title");

    public QManual(String variable) {
        super(Manual.class, forVariable(variable));
    }

    public QManual(Path<? extends Manual> path) {
        super(path.getType(), path.getMetadata());
    }

    public QManual(PathMetadata metadata) {
        super(Manual.class, metadata);
    }

}


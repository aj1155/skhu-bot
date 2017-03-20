package me.gomko.api.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QApiInfo is a Querydsl query type for ApiInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QApiInfo extends EntityPathBase<ApiInfo> {

    private static final long serialVersionUID = -305373715L;

    public static final QApiInfo apiInfo = new QApiInfo("apiInfo");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<org.joda.time.DateTime> createdDate = _super.createdDate;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<org.joda.time.DateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath path = createString("path");

    public final StringPath title = createString("title");

    public QApiInfo(String variable) {
        super(ApiInfo.class, forVariable(variable));
    }

    public QApiInfo(Path<? extends ApiInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QApiInfo(PathMetadata metadata) {
        super(ApiInfo.class, metadata);
    }

}


package me.gomko.api.repository.Impl;

import com.querydsl.core.BooleanBuilder;
import me.gomko.api.domain.Manual;
import me.gomko.api.domain.QManual;
import me.gomko.api.repository.custom.ManualRepositoryCustom;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

/**
 * Created by Manki Kim on 2017-03-20.
 */
public class ManualRepositoryImpl extends QueryDslRepositorySupport implements ManualRepositoryCustom {

    QManual qManual = QManual.manual;

    public ManualRepositoryImpl() { super(Manual.class); }

    @Override
    public List<Manual> readByTitleAndMessage(String title,List<String> list) {
        BooleanBuilder hasAllSkills = new BooleanBuilder();
        list.stream().forEach(data -> {
            hasAllSkills.and(qManual.message.contains(data));
        });
        hasAllSkills.and(qManual.title.contains(title));
        return from(qManual)
                .where(hasAllSkills)
                .fetch();
    }
}

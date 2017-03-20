package me.gomko.api.repository.custom;

import me.gomko.api.domain.Manual;

import java.util.List;

/**
 * Created by Manki Kim on 2017-03-20.
 */
public interface ManualRepositoryCustom {
    List<Manual> readByTitleAndMessage(String title,List<String> list);
}

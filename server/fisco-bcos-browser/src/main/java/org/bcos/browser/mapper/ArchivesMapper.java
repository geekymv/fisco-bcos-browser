package org.bcos.browser.mapper;

import org.apache.ibatis.annotations.Param;
import org.bcos.browser.entity.dto.Archives;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchivesMapper {
    void addArchives(Archives user);

    Archives getArchivesById(@Param("archivesId") String archivesId);
}

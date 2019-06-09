package com.yinchuan.yunshu.storage;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Sort;

/**
 * Interface for accessing Storage Table.
 * @Author Siyuan Zeng
 */
public interface StorageRepository extends CrudRepository<Storage, Integer> {
    /**
     * Gets good from the table by user_id
     * @param userId The id of the user owns this good
     * @return Storage object
     */
    List<Storage> findByUserId(int userId, Sort sort);

    /**
     * Gets good from the table by good type
     * @param type the type of the good that want to find
     * @return Storage object
     */
    List<Storage> findByType(String type);

    /**
     * Gets all goods in storage.
     * @return All goods in storage
     */
    List<Storage> findAll();

    /**
     * Get a good by given userId and goodId
     * @param id the id of the given good
     * @param userId the id of the given user
     * @return desired good.
     */
    Storage findByIdAndUserId(int id, int userId);

}

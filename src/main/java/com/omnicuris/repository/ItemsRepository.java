package com.omnicuris.repository;

import com.omnicuris.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemsRepository extends JpaRepository<Items,Long> {

    Optional<Items> findByIdAndActiveTrue(Long itemId);
}

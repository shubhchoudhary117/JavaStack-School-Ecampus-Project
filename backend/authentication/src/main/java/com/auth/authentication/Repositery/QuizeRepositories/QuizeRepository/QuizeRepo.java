package com.auth.authentication.Repositery.QuizeRepositories.QuizeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;
import com.auth.authentication.Entities.TestQuizes.QuizeDetails.*;
import com.auth.authentication.Entities.TestQuizes.Category.*;
public interface QuizeRepo  extends JpaRepository<Quize,Integer>{
    // get quize by id
    @Query(value="select * from quize where qid=:id",nativeQuery=true)
    public Quize getQuizeById(@Param("id")int id);

    // get quize by category
    public Set<Quize> findByCategory(Categories category);

    // get active quizes
    public Set<Quize> findByActive(Boolean active);

    // get active quize by category
    public Set<Quize> findByCategoryAndActive(Categories category,Boolean active);
}

package com.example.DubsArt.repositories;

import com.example.DubsArt.model.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia, Integer> {
    List<Multimedia> findByOrderById();

    @Query(
            value="SELECT * FROM Multimedia AS m WHERE m left join publicaciones as p On p.multimedia_id=m.id where p.id= %?1%",
            nativeQuery=true)
    public Multimedia getByPublication(int id);
}


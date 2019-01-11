package soba;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SobaRepository extends JpaRepository<Soba, Integer>{
}

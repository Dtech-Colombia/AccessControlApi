package co.com.dtech.accesscontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.dtech.accesscontrol.common.entity.Tag;

@Repository
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public interface TagRepository extends JpaRepository<Tag, Integer> {
	
	Tag findByTagCode(String tagCode);

}

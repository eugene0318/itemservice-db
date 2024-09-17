package hello.itemservice.repository.mybatis;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
/*
 * 마이바티스 매핑 xml을 호출해주는 매핑 인터페이스
 * 이 인터페이스의 메서드를 호출하면 xml의 해당 sql을 실행하고 결과를 보여준다.
 * 인터페이스의 메서드명과 xml파일의 Id 일치해야한다.
 */
@Mapper
public interface ItemMapper {

	void save(Item item);
	
	void update(@Param("id") Long id, @Param("updateParam") ItemUpdateDto updateParam);
	
	List<Item> findAll(ItemSearchCond itemSearch);
	
	Optional<Item> findById(Long id);
}

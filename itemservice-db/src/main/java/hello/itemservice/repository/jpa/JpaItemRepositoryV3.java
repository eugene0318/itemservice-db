package hello.itemservice.repository.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.jpa.impl.JPAQueryFactory;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;

@Repository
@Transactional
public class JpaItemRepositoryV3 implements ItemRepository {

	private final EntityManager em;
	private final JPAQueryFactory query;

	public JpaItemRepositoryV3(EntityManager em) {
		this.em = em;
		this.query = new JPAQueryFactory(em);
	}

	@Override
	public Item save(Item item) {
		em.persist(item);
		return item;
	}

	@Override
	public void update(Long itemId, ItemUpdateDto updateParam) {
		Item findItem = findById(itemId).orElseThrow();
		findItem.setItemName(updateParam.getItemName());
		findItem.setPrice(updateParam.getPrice());
		findItem.setQuantity(updateParam.getQuantity());
	}

	@Override
	public Optional<Item> findById(Long id) {
		Item item = em.find(Item.class, id);
		return Optional.ofNullable(item);
	}

	@Override
	public List<Item> findAll(ItemSearchCond cond) {
		String itemName = cond.getItemName();
		Integer maxPrice = cond.getMaxPrice();
		return null;

	}

}

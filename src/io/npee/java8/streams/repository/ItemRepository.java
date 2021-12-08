package io.npee.java8.streams.repository;

import io.npee.java8.streams.domain.Item;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository implements Repository<Item> {

    private static Long AUTO_GENERATED_TEST_ID = 1L;
    private List<Item> items = new ArrayList<>();

    @Override
    public List<Item> findAll() {
        return items;
    }

    @Override
    public Item findById(Long id) {
        Item item = null;
        if (items.size() == 0) {
            throw new IllegalStateException();
        }

        for (int i = 0; i < items.size(); i++) {
            Item findItem = items.get(i);
            if (id.equals(findItem.getId())) {
                item = findItem;
            }
        }

        if (item == null) {
            throw new IllegalArgumentException();
        } else {
            return item;
        }
    }

    @Override
    public Item save(Item entity) {
        if (entity.getId() == null) {
            Item savedItem = new Item(AUTO_GENERATED_TEST_ID++, entity.getName(), entity.getPrice(), entity.getDescription());
            items.add(savedItem);
            return findById(savedItem.getId());
        } else {
            Item updatedItem = findById(entity.getId());
            updatedItem.setName(entity.getName());
            updatedItem.setPrice(entity.getPrice());
            updatedItem.setDescription(entity.getDescription());
            return updatedItem;
        }
    }

    @Override
    public int deleteById(Long id) {
        Item item = findById(id);
        boolean isRemoved = items.remove(item);
        return isRemoved ? 1 : 0;
    }
}

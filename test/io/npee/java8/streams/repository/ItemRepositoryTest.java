package io.npee.java8.streams.repository;

import static org.junit.jupiter.api.Assertions.*;

import io.npee.java8.streams.domain.Item;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @BeforeEach
    void setUp() {
        for (int i = 1; i < 11; i++) {
            Item item = new Item(null,"item" + i, 10000 * i, "아이템" + i);
            itemRepository.save(item);
        }
    }

    @Test
    void repositoryTest() {
        List<Item> all = itemRepository.findAll();
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i));
        }
    }

}
package io.npee.java8.data.repository;

import static org.junit.jupiter.api.Assertions.*;

import io.npee.java8.data.domain.Item;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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

    @Test
    void deleteTest() {
        itemRepository.deleteById(2L);
        List<Item> all = itemRepository.findAll();
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i));
        }
        assertEquals(9, all.size());
    }

    @Test
    void deleteExceptionTest() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                itemRepository.deleteById(20L);
            }
        });
    }
}
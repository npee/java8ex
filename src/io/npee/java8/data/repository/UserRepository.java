package io.npee.java8.data.repository;

import io.npee.java8.data.domain.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Repository<User> {

    private static Long AUTO_GENERATED_TEST_ID = 1L;
    private List<User> users = new ArrayList<>();

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(Long id) {
        User user = null;
        if (users.size() == 0) {
            throw new IllegalStateException();
        }

        for (int i = 0; i < users.size(); i++) {
            User findUser = users.get(i);
            if (id.equals(findUser.getId())) {
                user = findUser;
            }
        }

        if (user == null) {
            throw new IllegalArgumentException();
        } else {
            return user;
        }
    }

    @Override
    public User save(User entity) {
        if (entity.getId() == null) {
            User savedUser = new User(AUTO_GENERATED_TEST_ID++, entity.getName(), entity.getEmail(), entity.getPhone());
            users.add(savedUser);
            return findById(savedUser.getId());
        } else {
            User updatedUser = findById(entity.getId());
            updatedUser.setName(entity.getName());
            updatedUser.setEmail(entity.getEmail());
            updatedUser.setPhone(entity.getPhone());
            return updatedUser;
        }
    }

    @Override
    public int deleteById(Long id) {
        User user = findById(id);
        boolean isRemoved = users.remove(user);
        return isRemoved ? 1 : 0;
    }
}

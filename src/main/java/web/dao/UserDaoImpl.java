package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        String query = "from User";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        return typedQuery.getResultList();
    }
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public User show(Long id) {return id != null ? entityManager.find(User.class, id) : null;}
    @Override
    public void update(Long id, User updatedUser) {
        User userToUpdate = entityManager.find(User.class, id);
        userToUpdate.setFirstName(updatedUser.getFirstName());
        userToUpdate.setLastName(updatedUser.getLastName());
        userToUpdate.setEmail(updatedUser.getEmail());

    }

    @Override
    public void delete (Long id) {
        User userToDelete = entityManager.find(User.class, id);
        entityManager.remove(userToDelete);
    }
}

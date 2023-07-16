package spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.models.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PersonDAO {


    @PersistenceContext
    EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;
   // entityManager = entityManagerFactory.createEntityManager();
    @Autowired
    public PersonDAO(EntityManagerFactory entityManagerFactory) {

        this.entityManagerFactory = entityManagerFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        return entityManagerFactory.createEntityManager().createQuery("select p from Person p", Person.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        return entityManagerFactory.createEntityManager().find(Person.class, id);

    }


    public void save(Person person) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
    }


    public void update(int id, Person updatePerson) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Person personToBeUpdated = entityManager.find(Person.class, id);
        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
        entityManager.getTransaction().commit();
    }


    public void delete(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        Person person = entityManager.find(Person.class,id);
        entityManager.getTransaction().begin();
        entityManager.remove(person);
        entityManager.getTransaction().commit();
    }

}


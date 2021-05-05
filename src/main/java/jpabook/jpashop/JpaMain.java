package jpabook.jpashop;

import jpabook.jpashop.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();

        // 간단하게 entityManager는 DB 커넥션 1개를 받았다고 생각하면 쉽다.
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // 실제 코드가 들어가는 부분
        try {
            Album album = new Album();
            album.setArtist("김가수");

            Book book = new Book();
            book.setAuthor("김 글쓴이");

            Movie movie = new Movie();
            movie.setActor("김 배우");

            entityManager.persist(album);
            entityManager.persist(book);
            entityManager.persist(movie);

            transaction.commit();
        }
        catch(Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        emf.close();
    }
}

package io.multiverse.moodtracker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class MoodtrackerEntityTest {
    
    @Autowired
    private MoodRepo repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void canCreateMood() {
        Mood mood = new Mood();
        mood.setScore(7);
        mood.setUserId("1");
        Mood moodRecord = repo.save(mood);

        assertEquals("1", moodRecord.getUserId());
    }

}

package io.multiverse.moodtracker;

import org.springframework.data.jpa.repository.JpaRepository;

interface MoodRepo extends JpaRepository<Mood, Integer> {}

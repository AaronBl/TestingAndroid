package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`

class StatisticsUtilsTest {
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnHundredZero() {

        // Create an active task (the false makes this active)
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = false)
        )
        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }


    @Test
    fun getActiveAndCompletedStats_noActive_returnZeroHundred() {
        val task = listOf<Task>(Task("titlwe", "des", isCompleted = true))
        val result = getActiveAndCompletedStats(task)
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_CompleteAndNotCompleted_returnFortyFifty() {
        val task = listOf<Task>(
                Task("titlwe", "des", isCompleted = false),
                Task("titlwe", "des", isCompleted = false),
                Task("titlwe", "des", isCompleted = true),
                Task("titlwe", "des", isCompleted = true),
                Task("titlwe", "des", isCompleted = true))
        val result = getActiveAndCompletedStats(task)
        assertThat(result.activeTasksPercent, `is`(40f))
        assertThat(result.completedTasksPercent, `is`(60f))
    }


    @Test
    fun getActiveAndCompletedStats_listNull_returnZero() {
        val result = getActiveAndCompletedStats(null)
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_listEmpy_returnZero() {
        val result = getActiveAndCompletedStats(emptyList())
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

}
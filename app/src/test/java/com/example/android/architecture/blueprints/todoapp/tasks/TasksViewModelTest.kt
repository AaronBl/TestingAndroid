package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {


    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    // Subject under test
    private lateinit var tasksViewModel: TasksViewModel

    //Cuando tenga un código de configuración repetido para varias pruebas,
    // puede usar la anotación @Before para crear un método de configuración y eliminar el código repetido.
    // Dado que todas estas pruebas van a probar TasksViewModely necesitan un modelo de vista.
    @Before
    fun setupViewModel(){
        tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
    }




    @Test
    fun addNewTask_setsNewTaskEvent() {
        // Given a fresh ViewModel

        // When adding a new task
        tasksViewModel.addNewTask()

        //Then the new task event is triggered
        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled(), not(nullValue()))


    }
    @Test
    fun setFilterAllTasks_tasksAddViewVisible(){

        tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)

        assertThat(tasksViewModel.tasksAddViewVisible.getOrAwaitValue(), `is`(true))


    }

}
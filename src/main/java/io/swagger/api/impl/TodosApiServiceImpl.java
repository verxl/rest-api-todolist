package io.swagger.api.impl;

import io.swagger.api.TodosApi;
import io.swagger.model.Todo;

import java.util.ArrayList;
import java.util.List;


/**
 * TodoList
 *
 * <p>Simple TodoList App created with the help of Swagger Editor
 *
 */
public class TodosApiServiceImpl implements TodosApi {
    private List<Todo> todos;
    /**
     * Add a new todo to the todo list
     *
     */
    public Todo addTodo(String name, String description, Long dueDate, Long status, Todo body) {
        body.setName(name);
        body.setDescription(description);
        body.setDueDate(dueDate);
        body.setStatus(Math.toIntExact(status));
        return body;
    }
    
    /**
     * Create a new todo list
     *
     */
    public List<Todo> createTodos(List<Todo> body) {
        return body;
    }
    
    /**
     * Filter the todos by due date
     *
     * Filter the todos by the due date inputted
     *
     */
    public List<Todo> filter(Integer dueDate) {
        List<Todo> result = new ArrayList<>();
        for (Todo todo: this.todos) {
            if (Math.toIntExact(todo.getDueDate()) == dueDate) {
                result.add(todo);
            }
        }
        return result;
    }
    
    /**
     * Deletes a todo
     *
     */
    public void removeTodo(String name, String description, Long dueDate, Long status) {
        Todo item = new Todo();
        item.setName(name);
        item.setDescription(description);
        item.setDueDate(dueDate);
        item.setStatus(Math.toIntExact(status));
        for (Todo currentTodo : todos) {
            if (currentTodo.equals(item)) {
                this.todos.remove(currentTodo);
            }
        }
    }
    
    /**
     * Sort the todo list by due date
     *
     */
    public List<Todo> sort() {
        return sortWithInput(todos);
    }

    public List<Todo> sortWithInput(List<Todo> todoToSort) {
        int i = 1;
        while (i < todoToSort.size()) {
            Todo front = todoToSort.get(i - 1);
            Todo back = todoToSort.get(i);

            if (!(back.getDueDate() >= front.getDueDate())) {
                todoToSort.remove(back);
                todoToSort.add(i - 1, back);
                sortWithInput(todoToSort.subList(0, i));
            }
            i++;
        }
        return todoToSort;
    }
    
}


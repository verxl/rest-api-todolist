package io.swagger.api;

import io.swagger.model.Todo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.List;

/**
 * TodoList
 *
 * <p>Simple TodoList App created with the help of Swagger Editor
 *
 */
@Path("/")
public interface TodosApi  {

    /**
     * Add a new todo to the todo list
     *
     */
    @PUT
    @Path("/todos/add")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Add a new todo to the todo list", tags={ "todos" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Todo.class))),
        @ApiResponse(responseCode = "405", description = "Invalid input") })
    public Todo addTodo(@QueryParam("name") @NotNull String name, @QueryParam("description") @NotNull String description, @QueryParam("dueDate") @NotNull Long dueDate, @QueryParam("status") @NotNull Long status, @Valid Todo body);

    /**
     * Create a new todo list under the userId
     *
     */
    @POST
    @Path("/todos/create")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Create a new todo list under the userId", tags={ "todos" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Todo.class)))),
        @ApiResponse(responseCode = "405", description = "Invalid user") })
    public List<Todo> createTodos(@Valid List<Todo> body);

    /**
     * Filter the todos by due date
     *
     * Filter the todos by the due date inputted
     *
     */
    @GET
    @Path("/todos/filter")
    @Produces({ "application/json" })
    @Operation(summary = "Filter the todos by due date", tags={ "todos" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Todo.class)))),
        @ApiResponse(responseCode = "400", description = "Invalid status value") })
    public List<Todo> filter(@QueryParam("duedate") @NotNull Integer duedate);

    /**
     * Deletes a todo
     *
     */
    @DELETE
    @Path("/todos/delete")
    @Operation(summary = "Deletes a todo", tags={ "todos" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Invalid todo entry") })
    public void removeTodo(@QueryParam("name") @NotNull String name, @QueryParam("description") @NotNull String description, @QueryParam("dueDate") @NotNull Long dueDate, @QueryParam("status") @NotNull Long status);

    /**
     * Sort the todo list by due date
     *
     */
    @GET
    @Path("/todos/sort")
    @Produces({ "application/json" })
    @Operation(summary = "Sort the todo list by due date", tags={ "todos" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Todo.class)))) })
    public List<Todo> sort();

}

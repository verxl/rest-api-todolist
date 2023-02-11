package io.swagger.api;

import io.swagger.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.List;

/**
 * TodoList
 *
 * <p>Simple TodoList App created with the help of Swagger Editor
 *
 */
@Path("/")
public interface UserApi  {

    /**
     * Create user
     *
     * This can only be done by the logged in user.
     *
     */
    @POST
    @Path("/user")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Create user", tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))) })
    public User createUser(@Valid User body);

    /**
     * Creates list of users with given input array
     *
     * Creates list of users with given input array
     *
     */
    @POST
    @Path("/user/createWithList")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Creates list of users with given input array", tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
        @ApiResponse(responseCode = "200", description = "successful operation") })
    public User createUsersWithListInput(@Valid List<User> body);

    /**
     * Delete user
     *
     * This can only be done by the logged in user.
     *
     */
    @DELETE
    @Path("/user/{username}")
    @Operation(summary = "Delete user", tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Invalid username supplied"),
        @ApiResponse(responseCode = "404", description = "User not found") })
    public void deleteUser(@PathParam("username") String username);

    /**
     * Get user by user name
     *
     */
    @GET
    @Path("/user/{username}")
    @Produces({ "application/json" })
    @Operation(summary = "Get user by user name", tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
        @ApiResponse(responseCode = "400", description = "Invalid username supplied"),
        @ApiResponse(responseCode = "404", description = "User not found") })
    public User getUserByName(@PathParam("username") String username);

    /**
     * Logs user into the system
     *
     */
    @GET
    @Path("/user/login")
    @Produces({ "application/xml", "application/json" })
    @Operation(summary = "Logs user into the system", tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/xml", schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "400", description = "Invalid username/password supplied") })
    public String loginUser(@QueryParam("username") String username, @QueryParam("password") String password);

    /**
     * Logs out current logged in user session
     *
     */
    @GET
    @Path("/user/logout")
    @Operation(summary = "Logs out current logged in user session", tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation") })
    public void logoutUser();

    /**
     * Update user
     *
     * This can only be done by the logged in user.
     *
     */
    @PUT
    @Path("/user/{username}")
    @Consumes({ "application/json" })
    @Operation(summary = "Update user", tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation") })
    public void updateUser(@PathParam("username") String username, @Valid User body);
}

package com.Api;


import java.net.URI;
import java.util.Collection;
import java.util.HashMap;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;



import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.ws.rs.Produces;

@Path("/users") // Tells Jersey that this resource is accessible at URL
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResources {
	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();
	
	// frame work to store all users data
	private HashMap<Integer, user> usersMap = new HashMap<>();

	user newuser;

	//test accounts
	user testUser = new user(0, "arek", "arek@gmail.com", "aadfadfadfad", "");
	user testUser1 = new user(1, "The arekM", "ajsbxdjhs", "b", "");

	// constructor with same hard coded users//
	public UserApiResources() {
		usersMap.put(testUser.getUserId(), testUser);
		usersMap.put(testUser1.getUserId(), testUser1);

	}

	//getting all users
	@GET
	public Collection<user> getUsers() {

		return usersMap.values();
	}

	// Getting one user by id
	@GET
	@Path("/{userId}")
	public Response getUserById(@PathParam("userId") int id) throws Exception {

		int id1 = usersMap.get(id).getUserId();

		if (id < 0 || id != id1) {
			throw new Exception();
		} else {
			return Response.status(Status.OK).entity(usersMap.get(id)).build();

		}

	}
	
	//delete method for deleting users
	@DELETE
	@Path("{userId}")
	public Response deleteUser(@PathParam("userId") int id) throws Exception {

		if(id == usersMap.get(id).getUserId()) {
			usersMap.remove(id);
			return Response.ok(usersMap.values()).build();
		} else {
		
			return Response.status(Status.OK).entity(usersMap.get(id)).build();

		}
	}
	
	//put method for updating users
	@PUT
	@Path("/{userId}")
	public Response updateUser(@PathParam("userId")int id, user user) throws Exception {
		
		newuser = user;
		
		newuser.setUserId(id);
		
		usersMap.replace(id, user);
			
		return Response.status(Status.OK).entity(usersMap.get(id)).build();
	}
	
	//post methd for creating a new user 
	@POST
	  public Response newUser(user user) throws Exception {

	    int id = usersMap.size() + 1;

	    user.setUserId(id);

	    String usernew = String.valueOf(user.getUserId());

	    usersMap.put(id, user);

	    return Response.created(new URI("/users/" + usernew)).entity(usersMap.get(user.getUserId()))
	        .status(Status.CREATED).build();

	  }

}

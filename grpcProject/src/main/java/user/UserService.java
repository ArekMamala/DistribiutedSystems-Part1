package user;

import com.grpcproject.User.APIResponse;
import com.grpcproject.User.Empty;
import com.grpcproject.User.LoginRequest;
import com.grpcproject.userGrpc.userImplBase;
import grpcEncryption.Encryption;
import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		
		//Encryption encrypt = new Encryption();
		//System.out.println("login success");//print out to server
		
		//client username and password
		String username = request.getUsername();
		String password = request.getPassword();
		
		APIResponse.Builder response = APIResponse.newBuilder();
		if(username.equals(password)) {
			
			 // login sucessfull return message
			System.out.println(username);//client username	
			System.out.println(password);//client password
			System.out.println("hashed client username " + Encryption.hash(username));//hashing clients username
			System.out.println("salted client password " + Encryption.salt(password));//salting client password
			response.setResponseCode(0).setResponsemessage("login successful");//sending to client login successfull
			
		}
		else {
			// login unsucessfull return message
			System.out.println(username);//client username	
			System.out.println(password);//client password
			response.setResponseCode(100).setResponsemessage("unsuccessfull login");//sending to client login not successfull 
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	} 
}

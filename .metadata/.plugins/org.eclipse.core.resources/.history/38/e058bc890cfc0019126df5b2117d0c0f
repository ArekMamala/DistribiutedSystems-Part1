import com.grpcproject.User.APIResponse;
import com.grpcproject.User.LoginRequest;
import com.grpcproject.userGrpc;
import com.grpcproject.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

	public static void main(String[] args) {
		//srtrings username and pass
		String user = "arek";
		String pass = "arek";
		
		System.out.println("User id sent = " + user +"\nUser Password sent = " + pass);
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();
		
		// stubs - generate from proto
		userBlockingStub userStub = userGrpc.newBlockingStub(channel);
		
		LoginRequest loginrequest = LoginRequest.newBuilder().setUsername(user).setPassword(pass).build();
		
		APIResponse response = userStub.login(loginrequest);
		
		System.out.println(response.getResponsemessage());
		
		
	}

}
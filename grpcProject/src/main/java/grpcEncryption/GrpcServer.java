package grpcEncryption;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import user.UserService;

public class GrpcServer {

	public static void main(String args[]) throws IOException, InterruptedException {

		// encryption method hash
		String password = "arek";
		System.out.println("Password trial check " + password);
		System.out.println("hashed " + Encryption.hash(password));

		// encryption method Salt
		System.out.println("Salted " + Encryption.salt(password));

		/// server starting
		System.out.println("--\n\n GRPC Server started");
		Server server = ServerBuilder.forPort(9090).addService(

		new UserService()).build();

		server.start();
		System.out.println("port used for server " + server.getPort());
		server.awaitTermination();
	}
}
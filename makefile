generate:
	 protoc --plugin=protoc-gen-grpc-java=/opt/homebrew/bin/protoc-gen-grpc-java -I=./src/main/java/com/fajrulaulia/commandbackend/proto \
          --java_out=./src/main/java/ \
          --grpc-java_out=./src/main/java/ \
          ./src/main/java/com/fajrulaulia/commandbackend/proto/blog.proto
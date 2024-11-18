package renault.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: auth_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AuthServiceGrpc {

  private AuthServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "AuthService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<AuthServiceProto.RegisterRequest,
      AuthServiceProto.RegisterResponse> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Register",
      requestType = AuthServiceProto.RegisterRequest.class,
      responseType = AuthServiceProto.RegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<AuthServiceProto.RegisterRequest,
      AuthServiceProto.RegisterResponse> getRegisterMethod() {
    io.grpc.MethodDescriptor<AuthServiceProto.RegisterRequest, AuthServiceProto.RegisterResponse> getRegisterMethod;
    if ((getRegisterMethod = AuthServiceGrpc.getRegisterMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getRegisterMethod = AuthServiceGrpc.getRegisterMethod) == null) {
          AuthServiceGrpc.getRegisterMethod = getRegisterMethod =
              io.grpc.MethodDescriptor.<AuthServiceProto.RegisterRequest, AuthServiceProto.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AuthServiceProto.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AuthServiceProto.RegisterResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Register"))
              .build();
        }
      }
    }
    return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<AuthServiceProto.AuthenticateRequest,
      AuthServiceProto.AuthenticateResponse> getAuthenticateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Authenticate",
      requestType = AuthServiceProto.AuthenticateRequest.class,
      responseType = AuthServiceProto.AuthenticateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<AuthServiceProto.AuthenticateRequest,
      AuthServiceProto.AuthenticateResponse> getAuthenticateMethod() {
    io.grpc.MethodDescriptor<AuthServiceProto.AuthenticateRequest, AuthServiceProto.AuthenticateResponse> getAuthenticateMethod;
    if ((getAuthenticateMethod = AuthServiceGrpc.getAuthenticateMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getAuthenticateMethod = AuthServiceGrpc.getAuthenticateMethod) == null) {
          AuthServiceGrpc.getAuthenticateMethod = getAuthenticateMethod =
              io.grpc.MethodDescriptor.<AuthServiceProto.AuthenticateRequest, AuthServiceProto.AuthenticateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Authenticate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AuthServiceProto.AuthenticateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AuthServiceProto.AuthenticateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Authenticate"))
              .build();
        }
      }
    }
    return getAuthenticateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<AuthServiceProto.IntrospectRequest,
      AuthServiceProto.IntrospectResponse> getIntrospectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Introspect",
      requestType = AuthServiceProto.IntrospectRequest.class,
      responseType = AuthServiceProto.IntrospectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<AuthServiceProto.IntrospectRequest,
      AuthServiceProto.IntrospectResponse> getIntrospectMethod() {
    io.grpc.MethodDescriptor<AuthServiceProto.IntrospectRequest, AuthServiceProto.IntrospectResponse> getIntrospectMethod;
    if ((getIntrospectMethod = AuthServiceGrpc.getIntrospectMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getIntrospectMethod = AuthServiceGrpc.getIntrospectMethod) == null) {
          AuthServiceGrpc.getIntrospectMethod = getIntrospectMethod =
              io.grpc.MethodDescriptor.<AuthServiceProto.IntrospectRequest, AuthServiceProto.IntrospectResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Introspect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AuthServiceProto.IntrospectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AuthServiceProto.IntrospectResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Introspect"))
              .build();
        }
      }
    }
    return getIntrospectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<AuthServiceProto.ExpireRequest,
      AuthServiceProto.ExpireResponse> getExpireMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Expire",
      requestType = AuthServiceProto.ExpireRequest.class,
      responseType = AuthServiceProto.ExpireResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<AuthServiceProto.ExpireRequest,
      AuthServiceProto.ExpireResponse> getExpireMethod() {
    io.grpc.MethodDescriptor<AuthServiceProto.ExpireRequest, AuthServiceProto.ExpireResponse> getExpireMethod;
    if ((getExpireMethod = AuthServiceGrpc.getExpireMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getExpireMethod = AuthServiceGrpc.getExpireMethod) == null) {
          AuthServiceGrpc.getExpireMethod = getExpireMethod =
              io.grpc.MethodDescriptor.<AuthServiceProto.ExpireRequest, AuthServiceProto.ExpireResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Expire"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AuthServiceProto.ExpireRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AuthServiceProto.ExpireResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Expire"))
              .build();
        }
      }
    }
    return getExpireMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceStub>() {
        @java.lang.Override
        public AuthServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceStub(channel, callOptions);
        }
      };
    return AuthServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceBlockingStub>() {
        @java.lang.Override
        public AuthServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceBlockingStub(channel, callOptions);
        }
      };
    return AuthServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceFutureStub>() {
        @java.lang.Override
        public AuthServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceFutureStub(channel, callOptions);
        }
      };
    return AuthServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void register(AuthServiceProto.RegisterRequest request,
        io.grpc.stub.StreamObserver<AuthServiceProto.RegisterResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    default void authenticate(AuthServiceProto.AuthenticateRequest request,
        io.grpc.stub.StreamObserver<AuthServiceProto.AuthenticateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAuthenticateMethod(), responseObserver);
    }

    /**
     */
    default void introspect(AuthServiceProto.IntrospectRequest request,
        io.grpc.stub.StreamObserver<AuthServiceProto.IntrospectResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIntrospectMethod(), responseObserver);
    }

    /**
     */
    default void expire(AuthServiceProto.ExpireRequest request,
        io.grpc.stub.StreamObserver<AuthServiceProto.ExpireResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExpireMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AuthService.
   */
  public static abstract class AuthServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AuthServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AuthService.
   */
  public static final class AuthServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AuthServiceStub> {
    private AuthServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void register(AuthServiceProto.RegisterRequest request,
        io.grpc.stub.StreamObserver<AuthServiceProto.RegisterResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void authenticate(AuthServiceProto.AuthenticateRequest request,
        io.grpc.stub.StreamObserver<AuthServiceProto.AuthenticateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAuthenticateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void introspect(AuthServiceProto.IntrospectRequest request,
        io.grpc.stub.StreamObserver<AuthServiceProto.IntrospectResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIntrospectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void expire(AuthServiceProto.ExpireRequest request,
        io.grpc.stub.StreamObserver<AuthServiceProto.ExpireResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExpireMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AuthService.
   */
  public static final class AuthServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AuthServiceBlockingStub> {
    private AuthServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public AuthServiceProto.RegisterResponse register(AuthServiceProto.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public AuthServiceProto.AuthenticateResponse authenticate(AuthServiceProto.AuthenticateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAuthenticateMethod(), getCallOptions(), request);
    }

    /**
     */
    public AuthServiceProto.IntrospectResponse introspect(AuthServiceProto.IntrospectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIntrospectMethod(), getCallOptions(), request);
    }

    /**
     */
    public AuthServiceProto.ExpireResponse expire(AuthServiceProto.ExpireRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExpireMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AuthService.
   */
  public static final class AuthServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AuthServiceFutureStub> {
    private AuthServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<AuthServiceProto.RegisterResponse> register(
        AuthServiceProto.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<AuthServiceProto.AuthenticateResponse> authenticate(
        AuthServiceProto.AuthenticateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAuthenticateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<AuthServiceProto.IntrospectResponse> introspect(
        AuthServiceProto.IntrospectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIntrospectMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<AuthServiceProto.ExpireResponse> expire(
        AuthServiceProto.ExpireRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExpireMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_AUTHENTICATE = 1;
  private static final int METHODID_INTROSPECT = 2;
  private static final int METHODID_EXPIRE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((AuthServiceProto.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<AuthServiceProto.RegisterResponse>) responseObserver);
          break;
        case METHODID_AUTHENTICATE:
          serviceImpl.authenticate((AuthServiceProto.AuthenticateRequest) request,
              (io.grpc.stub.StreamObserver<AuthServiceProto.AuthenticateResponse>) responseObserver);
          break;
        case METHODID_INTROSPECT:
          serviceImpl.introspect((AuthServiceProto.IntrospectRequest) request,
              (io.grpc.stub.StreamObserver<AuthServiceProto.IntrospectResponse>) responseObserver);
          break;
        case METHODID_EXPIRE:
          serviceImpl.expire((AuthServiceProto.ExpireRequest) request,
              (io.grpc.stub.StreamObserver<AuthServiceProto.ExpireResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getRegisterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              AuthServiceProto.RegisterRequest,
              AuthServiceProto.RegisterResponse>(
                service, METHODID_REGISTER)))
        .addMethod(
          getAuthenticateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              AuthServiceProto.AuthenticateRequest,
              AuthServiceProto.AuthenticateResponse>(
                service, METHODID_AUTHENTICATE)))
        .addMethod(
          getIntrospectMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              AuthServiceProto.IntrospectRequest,
              AuthServiceProto.IntrospectResponse>(
                service, METHODID_INTROSPECT)))
        .addMethod(
          getExpireMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              AuthServiceProto.ExpireRequest,
              AuthServiceProto.ExpireResponse>(
                service, METHODID_EXPIRE)))
        .build();
  }

  private static abstract class AuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return AuthServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthService");
    }
  }

  private static final class AuthServiceFileDescriptorSupplier
      extends AuthServiceBaseDescriptorSupplier {
    AuthServiceFileDescriptorSupplier() {}
  }

  private static final class AuthServiceMethodDescriptorSupplier
      extends AuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AuthServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthServiceFileDescriptorSupplier())
              .addMethod(getRegisterMethod())
              .addMethod(getAuthenticateMethod())
              .addMethod(getIntrospectMethod())
              .addMethod(getExpireMethod())
              .build();
        }
      }
    }
    return result;
  }
}

package com.example

import io.grpc.stub.StreamObserver
import jakarta.inject.Singleton

@Singleton // (1)
class GreetingEndpoint : MicronautHyServiceGrpc.MicronautHyServiceImplBase() { // (2)
    override fun send(request: MicronautHyRequest, responseObserver: StreamObserver<MicronautHyReply>) {
        // (3)
        val message = "this is message from server, requset param is: [${request.name}]"
        val reply = MicronautHyReply.newBuilder().setMessage(message).build()
        responseObserver.onNext(reply)
        responseObserver.onCompleted()
    }
}
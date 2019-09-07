package com.tosit.genius.util;

public class Response<T> {
    public T data;
    public int status;

    public Response(T data){
        this.data=data;
    }
    public Response(T data,int status){
        this.data=data;
        this.status=status;
    }
    public Response(){
        this.status=1;
    }

}

package com.ladder.backend.common;

public record ApiRsp<T>(int code, String message, T data) {
  public static <T> ApiRsp<T> ok(T data) {
    return new ApiRsp<T>(0, "ok", data);
  }

  public static <T> ApiRsp<T> fail(int code, String message) {
    return new ApiRsp<T>(code, message, null);
  }
}

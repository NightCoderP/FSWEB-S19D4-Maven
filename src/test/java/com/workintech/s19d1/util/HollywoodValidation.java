package com.workintech.s19d1.util;

import com.workintech.s19d1.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class HollywoodValidation {
    public static void checkId(long id) {
        if (id <= 0) {
            throw new ApiException("ID sıfırdan büyük olmalıdır: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkEntityExists(Object entity, long id) {
        if (entity == null) {
            throw new ApiException(id + " ID'sine sahip kayıt bulunamadı.", HttpStatus.NOT_FOUND);
        }
    }
}